package filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AuthenticationFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
	        throws IOException, ServletException {
	    HttpServletRequest request = (HttpServletRequest) req;
	    HttpServletResponse response = (HttpServletResponse) res;
	    String requestUrl = request.getRequestURI();
	    HttpSession session = request.getSession(false);
	    
//	    System.out.println("Filter hit");
//	    System.out.println("Request URL: " + requestUrl);
//	    System.out.println("Session: " + session);
	    
	    if (requestUrl.endsWith(".css")) {
	        chain.doFilter(request, response);
	        return;
	    }
	    else if(requestUrl.endsWith(".png") || requestUrl.endsWith(".jpg")) {
	    	chain.doFilter(request, response);
	        return;
	    }

	    else if (requestUrl.endsWith("/") || requestUrl.endsWith("login") || requestUrl.endsWith("register") || requestUrl.endsWith("home")
	            || requestUrl.endsWith("logout") || requestUrl.endsWith("profile") || requestUrl.endsWith("admin") || requestUrl.endsWith("product") 
	    		|| requestUrl.endsWith("editProduct") || requestUrl.endsWith("addProduct") || requestUrl.endsWith("updateProduct") || requestUrl.endsWith("deleteProduct")
	    		|| requestUrl.endsWith("viewProduct") || requestUrl.endsWith("addToCart") || requestUrl.endsWith("cart") || requestUrl.endsWith("checkout")
	    		|| requestUrl.endsWith("userOrder") || requestUrl.endsWith("removeItem") || requestUrl.endsWith("increaseItem")|| requestUrl.endsWith("reduceItem"))
	    {
	        
	    	if (session == null) {
	            System.out.println("Session is null, forwarding to login");
	            request.getRequestDispatcher("/login").forward(request, response);
	            
	        }
	    	
	    	else if (session.getAttribute("username") != null) {
	    		chain.doFilter(request, response);
	        } 
	    	
	    	else if (session.getAttribute("username") == null) {

				if (requestUrl.endsWith("profile") || requestUrl.endsWith("logout") || requestUrl.endsWith("admin") || requestUrl.endsWith("product")){
					response.sendRedirect(request.getContextPath() + "/login");
				}

				else {

					chain.doFilter(request, response);
				}
	    	}
	    }
	    else {
	    	request.getRequestDispatcher("/error").forward(request, response);
	    }
	    
	}


	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub

	}

}
