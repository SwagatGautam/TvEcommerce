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
 * Servlet implementation class UpdateProduct
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/updateProduct" })
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
maxFileSize = 1024 * 1024 * 10,      // 10MB
maxRequestSize = 1024 * 1024 * 50)  // 50MB
public class ProductUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductDAO productDAO;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductUpdate() {
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
		System.out.println("hitted");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("post method");
		int id = Integer.parseInt(request.getParameter("id"));
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
		product.setId(id);
		product.setProductName(productName);
		product.setProductDescription(productDescription);
		product.setScreenSize(screenSize);
		product.setQuantity(quantity);
		product.setBrand(brand);
		product.setPrice(price);
		product.setProductImage(productData);
		product.setProductImageName(productImageName);
	
		
	    try {
	        int updated = productDAO.updateProduct(product);
	        if (updated > 0) {
	            System.out.println("Product updated successfully");
	            request.getRequestDispatcher("WEB-INF/view/viewProduct.jsp").forward(request, response);
	            return; 
	        } else {
	        	System.out.println("redirected");
	            response.sendRedirect("addProduct");
	            return;
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	        System.out.println("error");
	        response.sendRedirect("errorPage.jsp");
	        return; 
	    }
		
		
	}

}
