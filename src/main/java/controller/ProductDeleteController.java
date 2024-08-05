package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Product;
import service.ProductDAO;

/**
 * Servlet implementation class DeleteProductController
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/deleteProduct" })
public class ProductDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductDAO productDAO;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductDeleteController() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    @Override
    public void init() {
    	productDAO = new ProductDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id=Integer.valueOf(request.getParameter("id"));
		
            Product product = new Product();
            product.setId(id);
            try {
				int rowsDeleted = productDAO.deleteProduct(product);
				if (rowsDeleted>0) {
					System.out.println("deleted");
				}
			} catch (SQLException e) {
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
