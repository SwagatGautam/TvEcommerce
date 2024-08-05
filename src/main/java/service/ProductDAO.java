package service;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Product;
import utils.DbConnectivity;

public class ProductDAO {
	
	private Connection conn;
	private PreparedStatement statement;
	private ResultSet resultSet;
	private static final String productInsert = "insert into product "
	        + "(productName, productDescription, screenSize, quantity, brand, price, productImage, productImageName) "
	        + "values (?, ?, ?, ?, ?, ?, ?, ?)";

	public ProductDAO() {
		conn = DbConnectivity.getDbConnection();
	}
	
	public int deleteProduct(Product product) throws SQLException { 
		statement = conn.prepareStatement("delete * from product where id=?");
		int row = statement.executeUpdate();
		return row;
	}
	
	public int updateProduct(Product product) throws SQLException {
		int row;
		
			statement=conn.prepareStatement("update product set productName=?,productDescription=?,screenSize=?,quantity=?,brand=?,price=?,productImage=?,productImageName=? where id=?");
		    
			System.out.println(product.getProductName());
		    System.out.println("ID " + product.getId());
			statement.setString(1, product.getProductName());
		     statement.setString(2, product.getProductDescription());
		     statement.setString(3, product.getScreenSize());
		     statement.setInt(4, product.getQuantity());
		     statement.setString(5, product.getBrand());
		     statement.setFloat(6, product.getPrice());
		     
			Blob blob = conn.createBlob();
			blob.setBytes(1, product.getProductImage());
			statement.setBlob(7, blob); 
			statement.setString(8, product.getProductImageName());
			statement.setInt(9, product.getId()); 
		     
		     row=statement.executeUpdate();
		     System.out.println("row"+row);
		     System.out.println("update bhayo");
	     
		
	     return row;
	}
	
	public Product getProductById(int id) throws SQLException {
		statement=conn.prepareStatement("select id,productName,productDescription,screenSize,quantity,brand,price from product where id=?");
		statement.setInt(1, id);
		resultSet =statement.executeQuery();
		Product product=new Product();
		if(resultSet.next())
		{
			product.setId(resultSet.getInt("id"));
			product.setProductName(resultSet.getString("productName"));
			product.setProductDescription(resultSet.getString("productDescription"));
			product.setScreenSize(resultSet.getString("screenSize"));
			product.setQuantity(resultSet.getInt("quantity"));
			product.setBrand(resultSet.getString("brand"));
			product.setPrice(resultSet.getFloat("price"));
			
		}
		return product;
		
		
	}
	
	//view all product
	public List<Product> viewAllProduct() throws SQLException {
		List<Product> productList = new ArrayList<Product>();
		String viewQuery = "select * from product";
		statement = conn.prepareStatement(viewQuery);
		resultSet = statement.executeQuery();
		
		while(resultSet.next()) {
			int id = resultSet.getInt("id");
			String productName = resultSet.getString("productName"); 
			String productDescription = resultSet.getString("productDescription"); 
			String screenSize = resultSet.getString("screenSize");
			int quantity = resultSet.getInt("quantity");
			String brand = resultSet.getString("brand");
			float price = resultSet.getFloat("price");
			
			
			Product product = new Product();
			product.setId(id);
			product.setProductName(productName);
			product.setProductDescription(productDescription);
			product.setScreenSize(screenSize);
			product.setQuantity(quantity);
			product.setBrand(brand);
			product.setPrice(price);
			product.setProductImage(resultSet.getBlob("productImage").getBytes(1, (int)resultSet.getBlob("productImage").length()));
			
			productList.add(product);
			
		}
		return productList;
		
	}
	
	
	public boolean addProduct(Product product) throws SQLException {
		
		int rows = insertProduct(product);
		if (rows>0) {
			return true;
		}
		return false;
//		
//		String query = "select count(*) from product";
//		try {
//			statement = conn.prepareStatement(query);
//			resultSet = statement.executeQuery();
//			if(resultSet.next()) {
//				int rows = insertProduct(product);
//				if(rows>0) {
//					productAdded=true;
//				} 
//			}
//			else {
//				
//			}
//				
//			
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		return isSuccess;
		
	}
	
	public int insertProduct(Product product) throws SQLException {
		statement = conn.prepareStatement(productInsert);
		
		statement.setString(1, product.getProductName());
		statement.setString(2, product.getProductDescription());
		statement.setString(3, product.getScreenSize());
		statement.setInt(4, product.getQuantity());
		statement.setString(5, product.getBrand());
		statement.setFloat(6, product.getPrice());
		
		Blob blob = conn.createBlob();
		blob.setBytes(1, product.getProductImage());
		statement.setBlob(7, blob); 
		statement.setString(8, product.getProductImageName());
		
		int rows = statement.executeUpdate();
		
		return rows;
		
	}
	

}
