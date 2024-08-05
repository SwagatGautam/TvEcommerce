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

import model.Cart;
import model.Product;
import service.CartDAO;
import service.ProductDAO;

/**
 * Servlet implementation class CartPageController
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/cart" })
public class CartPageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartPageController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		    // Retrieve the cart list from the session
		    HttpSession session = request.getSession(false);
		    ArrayList<Cart> cartList = (ArrayList<Cart>) session.getAttribute("cartList");
		    
		    // Assuming you have a method to retrieve product details by ID
		    ProductDAO productDAO = new ProductDAO();
		    
		    // Iterate through the cart list and fetch product details for each item
		    if(cartList!= null) {
			    for (Cart cartItem : cartList) {
			        int productId = cartItem.getProductId();
			        try {
			            Product product = productDAO.getProductById(productId);
			            cartItem.setProduct(product);
			        } catch (SQLException e) {
			            // Handle exception
			        }
			    }
			    request.getRequestDispatcher("WEB-INF/view/cart.jsp").forward(request, response);
		    }
		    else {
		    	request.getRequestDispatcher("WEB-INF/view/error.jsp").forward(request, response);
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
