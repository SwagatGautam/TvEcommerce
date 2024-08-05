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

public class AuthorizationFilter implements Filter {

    @Override
    public void destroy() {
        // TODO Auto-generated method stub
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
            throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;

		String role = (String) request.getSession().getAttribute("role");

		if (role != null && role.equals("admin")) {


			
			if (request.getRequestURI().endsWith("addProduct")) {
				
				request.getRequestDispatcher("addProduct").forward(request, response);
			}
			else if (request.getRequestURI().endsWith("deleteProduct")) {
			
				request.getRequestDispatcher("deleteProduct").forward(request, response);
			}
			else if (request.getRequestURI().endsWith("admin")) {
				
				request.getRequestDispatcher("admin").forward(request, response);
			}
			else if ( request.getRequestURI().endsWith("editProduct")) {
				
				request.getRequestDispatcher("editProduct").forward(request, response);
			}
			else if ( request.getRequestURI().endsWith("updateProduct")) {
				
				request.getRequestDispatcher("updateProduct").forward(request, response);
			}
			else if (request.getRequestURI().endsWith("product")) {
				
				request.getRequestDispatcher("product").forward(request, response);
			}
			else if (request.getRequestURI().endsWith("logout")) {
				
				request.getRequestDispatcher("logout").forward(request, response);
			}
			else
			{
				request.getRequestDispatcher("admin").forward(request, response);
			}
		} 
		else if (role != null && role.equals("user")) 
		{


			if (request.getRequestURI().endsWith("logout"))
			{
				request.getRequestDispatcher("logout").forward(request, response);
			}
			else if (request.getRequestURI().endsWith("profile")) {

				request.getRequestDispatcher("profile").forward(request, response);
			}
			else if (request.getRequestURI().endsWith("viewProduct")) {

				request.getRequestDispatcher("viewProduct").forward(request, response);
			}
			else if (request.getRequestURI().endsWith("addToCart")) {

				request.getRequestDispatcher("addToCart").forward(request, response);
			}
			else if (request.getRequestURI().endsWith("cart")) {

				request.getRequestDispatcher("cart").forward(request, response);
			}
			else if (request.getRequestURI().endsWith("home"))
			{
				request.getRequestDispatcher("home").forward(request, response);
			}
			else if (request.getRequestURI().endsWith("checkout"))
			{
				request.getRequestDispatcher("checkout").forward(request, response);
			} 
			else if (request.getRequestURI().endsWith("userOrder"))
			{
				request.getRequestDispatcher("userOrder").forward(request, response);
			} 
			else if (request.getRequestURI().endsWith("removeItem"))
			{
				request.getRequestDispatcher("removeItem").forward(request, response);
			} 
			else if (request.getRequestURI().endsWith("increaseItem"))
			{
				request.getRequestDispatcher("increaseItem").forward(request, response);
			} 
			else if (request.getRequestURI().endsWith("reduceItem"))
			{
				request.getRequestDispatcher("reduceItem").forward(request, response);
			}
			else {
				request.getRequestDispatcher("error").forward(request, response);
			}
		}
		else

		{
			
			chain.doFilter(request, response);
		}
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // TODO Auto-generated method stub
    }
}
