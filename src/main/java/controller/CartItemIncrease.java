package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Cart;
import service.CartDAO;

/**
 * Servlet implementation class CartItemIncrease
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/increaseItem" })
public class CartItemIncrease extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartItemIncrease() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        int productId = Integer.parseInt(request.getParameter("productId"));

        
        ArrayList<Cart> cartList = (ArrayList<Cart>) request.getSession(false).getAttribute("cartList");

        
        CartDAO cartDAO = new CartDAO();
        cartDAO.increaseItemQuantity(cartList, productId);

        
        response.sendRedirect("cart");
    }

}
