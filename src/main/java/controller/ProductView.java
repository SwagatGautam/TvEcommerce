package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Product;
import service.ProductDAO;

/**
 * Servlet implementation class ViewProduct
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/product" })
public class ProductView extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductDAO productdao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductView() {
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
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			List<Product> listOfProduct=productdao.viewAllProduct();
			request.setAttribute("listOfProduct", listOfProduct);
			request.getRequestDispatcher("/WEB-INF/view/viewProduct.jsp").forward(request, response);
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
