package controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import model.Product;
import service.ProductDAO;


/**
 * Servlet implementation class AddProductController
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/addProduct" })
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
				maxFileSize = 1024 * 1024 * 10,      // 10MB
				maxRequestSize = 1024 * 1024 * 50)  // 50MB
public class ProductAddController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductDAO productdao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductAddController() {
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
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/WEB-INF/view/addProduct.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String productName = request.getParameter("productName");
		String productDescription = request.getParameter("productDescription");
		String screenSize = request.getParameter("screenSize");
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		String brand = request.getParameter("brand");
		float price = Float.parseFloat(request.getParameter("price"));
		
		Part filePart = request.getPart("image");
		String productImageName=filePart.getSubmittedFileName();
		InputStream imageStream=filePart.getInputStream();
		ByteArrayOutputStream buffer = new ByteArrayOutputStream();
		int bytesRead;
		int sizeInBytes = 2 * 1024 * 1024; 
		byte[] data = new byte[sizeInBytes];
		while ((bytesRead = imageStream.read(data, 0, data.length)) != -1) {
		    buffer.write(data, 0, bytesRead);
		}
		byte[] productData = buffer.toByteArray();


		
		
		Product product =new Product();
		product.setProductName(productName);
		product.setProductDescription(productDescription);
		product.setScreenSize(screenSize);
		product.setQuantity(quantity);
		product.setBrand(brand);
		product.setPrice(price);
		product.setProductImage(productData);
		product.setProductImageName(productImageName);
	
		
		try {
			boolean added = productdao.addProduct(product);
			if (added) {
				System.out.println("added");
			}else {
				response.sendRedirect("addProduct");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		doGet(request, response);
	}

}
