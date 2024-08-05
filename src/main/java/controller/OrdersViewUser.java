package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Order;
import service.OrderDAO;

/**
 * Servlet implementation class OrdersViewUser
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/userOrder" })
public class OrdersViewUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrdersViewUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve userID from session or request parameter
    	HttpSession session = request.getSession();
    	
        int userID = (int) session.getAttribute("id");
        System.out.println("lllllllllllll" + userID);
        // Create DAO instance and retrieve order details
        OrderDAO orderDAO = new OrderDAO();
        ArrayList<Order> orders = orderDAO.getOrdersByUserID(userID);

        // Set orders attribute to be used in JSP
        request.setAttribute("orders", orders);

        // Forward to a JSP to display order details
        request.getRequestDispatcher("WEB-INF/view/userOrder.jsp").forward(request, response);
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
