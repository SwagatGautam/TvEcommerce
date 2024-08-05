package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

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
 * Servlet implementation class CartAddController
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/addToCart" })
public class CartAddController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartAddController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
		
}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    // Initialize variables
	    ArrayList<Cart> tempCartList = new ArrayList<Cart>();
	    Cart cart = new Cart();
	    
	    // Get user ID and product ID from request
	    int userId = (int) request.getSession(false).getAttribute("id");
	    int productId = Integer.parseInt(request.getParameter("productId"));
	    System.out.println("user id: " + userId);
	    System.out.println("product id: " + productId);
	    
	    // Create a Cart object
	    cart.setUserId(userId);
	    cart.setProductId(productId);
	    cart.setcartQuantity(1);
	    
	    // Retrieve the cart list from the session attribute
	    HttpSession session = request.getSession();
	    ArrayList<Cart> cartList = (ArrayList<Cart>) session.getAttribute("cartList");
	    if (cartList == null) {
	        tempCartList.add(cart);
	        session.setAttribute("cartList", tempCartList);
	        System.out.println("Empty cart. Product ID: " + productId);
	    } 
	    if(cartList!= null) {
		    
		    System.out.println("arraylist: " + cartList);
		    
		    
		   
		        tempCartList = cartList;
		        boolean productFound = false;
		        
		        
		        for (Cart c : cartList) {
		            if (c.getProductId() == productId) {
		                productFound = true;
		                c.setcartQuantity(c.getcartQuantity()+1); 
		                System.out.println("Product Exists. Product ID: " + productId);
		                System.out.println("Quantity = " + c.getcartQuantity());
		                break;
		            }
		        }
		        
		        
		        if (!productFound) {
		            tempCartList.add(cart);
		            System.out.println("New product added. Product ID: " + productId);
		        }
		    }
		    

		    session.setAttribute("cartList", tempCartList);
		    response.sendRedirect("viewProduct");
	    }

	}

