package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import model.Cart;
import model.Order;
import utils.DbConnectivity;

public class OrderDAO {
	private Connection conn;
	private PreparedStatement statement;
	private ResultSet resultSet;

	public OrderDAO() {
		conn = DbConnectivity.getDbConnection();
	}
	
	public ArrayList<Order> getOrdersByUserID(int userID) {
        ArrayList<Order> orders = new ArrayList<>();
        
        try {
            String sql = "SELECT * FROM orders WHERE userId = ?";
            statement = conn.prepareStatement(sql);
            statement.setInt(1, userID);
            resultSet = statement.executeQuery();
            
            while (resultSet.next()) {
            	Order order = new Order();
            	
            	int id = resultSet.getInt("id");
            	int userId = resultSet.getInt("userId");
                int productId = resultSet.getInt("productId");
                String productName = resultSet.getString("productName");
                float unitPrice = resultSet.getFloat("unitPrice");
                int quantity = resultSet.getInt("quantity");
                
                order.setId(id);
                order.setUserId(userId);
                order.setProductId(productId);
                order.setProductName(productName);
                order.setUnitPrice(unitPrice);
                order.setQuantity(quantity);
                
                orders.add(order);
                
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return orders;
    }
	
    public int addItemsToOrder(ArrayList<Cart> cartItems) {
    	int rows = 0;
        try {
            
            String sql = "INSERT INTO orders (userId, productId, productName, unitPrice, quantity) VALUES (?, ?, ?, ?, ?)";
            statement = conn.prepareStatement(sql);
            
            for (Cart item : cartItems) {
            	statement.setInt(1, item.getUserId());
            	statement.setInt(2, item.getProductId());
            	statement.setString(3, item.getProduct().getProductName());
            	statement.setFloat(4, item.getProduct().getPrice());
            	statement.setInt(5, item.getcartQuantity());
            	rows = statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rows;
    }
}

