package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.cj.Session;

import model.Cart;
import model.Product;
import service.ProductDAO;

/**
 * Servlet implementation class UserProductView
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/viewProduct" })
public class UserProductView extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductDAO productdao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserProductView() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    @Override
    public void init() {
    	productdao = new ProductDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		try {
//			List<Product> listOfProduct=productdao.viewAllProduct();
//			request.setAttribute("listOfProduct", listOfProduct);
//			request.getRequestDispatcher("/WEB-INF/view/userViewProduct.jsp").forward(request, response);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}	
//		}
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
    	
    	ArrayList<Cart> cartList;
        ProductDAO pd = new ProductDAO();
        List<Product> products;
		try {
			products = pd.viewAllProduct();
		      request.setAttribute("products", products);

		      HttpSession session = request.getSession();
		      
		      cartList = (ArrayList<Cart>) session.getAttribute("cartList");
		      session.setAttribute("cartList", cartList);
		        if (cartList != null) {
		            request.setAttribute("cartList", cartList);
		        }

		        
		        request.getRequestDispatcher("WEB-INF/view/userViewProduct.jsp").forward(request, response);
		        
		        
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
  
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
