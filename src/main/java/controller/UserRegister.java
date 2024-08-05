package controller;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.User;
import service.UserDAO;
import utils.PasswordHashing;

/**
 * Servlet implementation class UserRegister
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/register" })
public class UserRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDAO dao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserRegister() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    @Override
    public void init() {
    	dao = new UserDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.sendRedirect("/WEB-INF/view/register.jsp")
		request.getRequestDispatcher("/WEB-INF/view/register.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fullName = request.getParameter("fullName");
		String email = request.getParameter("email");
		long phone = Long.parseLong(request.getParameter("phone"));
		String bithday = request.getParameter("birthday");
		Date dob = null;
		try {
			dob = new java.sql.Date(new SimpleDateFormat("yyyy-mm-dd").parse(bithday).getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		String gender = request.getParameter("gender");
		String address = request.getParameter("address");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String retypePassword = request.getParameter("retypePassword");
		
		if(!password.equals(retypePassword)) {
			request.setAttribute("error", "password doesn't match");
			request.getRequestDispatcher("/WEB-INF/view/register.jsp").forward(request, response);
			return;
		}
		
		User user = new User();
		user.setFullName(fullName);
		user.setEmail(email);
		user.setPhone(phone);
		user.setDob(dob);
		user.setGender(gender);
		user.setAddress(address);
		//hashing
		user.setPassword(PasswordHashing.getPasswordHash(password));
		user.setUsername(username);
		
		boolean isSuccess = dao.addUser(user);
		
		if(isSuccess) {
			response.sendRedirect("login");
		}else {
			request.setAttribute("error", "username or password or phonenumber is aliready taken");
			request.getRequestDispatcher("/WEB-INF/view/register.jsp").forward(request, response);
		}
	}

}
