package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Product;
import service.ProductDAO;

/**
 * Servlet implementation class EditProductController
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/editProduct" })
public class ProductEditController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductDAO productDAO;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductEditController() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    @Override
  public void init() throws ServletException {
  	// TODO Auto-generated method stub
  	super.init();
  	productDAO=new ProductDAO();
  }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("hit");
		int id=Integer.valueOf(request.getParameter("id"));
		
		try {
			Product product=productDAO.getProductById(id);
			request.setAttribute("product", product);
			HttpSession session=request.getSession();
			session.setAttribute("id", id);
			request.getRequestDispatcher("/WEB-INF/view/editProduct.jsp").forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
