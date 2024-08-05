package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Cart;
import utils.DbConnectivity;


public class CartDAO {
	private Connection conn;
	private PreparedStatement statement;
	private ResultSet resultSet;
	
	public CartDAO() {
		conn = DbConnectivity.getDbConnection();
	}
	
    public void reduceItemQuantity(ArrayList<Cart> cartList, int productId) {
        for (Cart cartItem : cartList) {
            if (cartItem.getProductId() == productId) {
                int currentQuantity = cartItem.getcartQuantity();
                if (currentQuantity > 1) { // Ensure quantity doesn't go below 1
                    cartItem.setcartQuantity(currentQuantity - 1);
                    break;
                }
            }
        }
    }

    public void increaseItemQuantity(ArrayList<Cart> cartList, int productId) {
        for (Cart cartItem : cartList) {
            if (cartItem.getProductId() == productId) {
                int currentQuantity = cartItem.getcartQuantity();
                cartItem.setcartQuantity(currentQuantity + 1);
                break;
            }
        }
    }
	
    public void removeItemFromCart(ArrayList<Cart> cartList, int productIdToRemove) {
        for (int i = 0; i < cartList.size(); i++) {
            Cart cartItem = cartList.get(i);
            if (cartItem.getProductId() == productIdToRemove) {
                cartList.remove(i);
            }
        }
    }
	
	public int insertIntoCart(Cart cart) throws SQLException {
	    String query = "INSERT INTO cart (userId, productId, quantity) VALUES (?, ?, ?)";
	    statement = conn.prepareStatement(query);
	    statement.setInt(1, cart.getUserId());
	    statement.setInt(2, cart.getProductId());
	    statement.setInt(3, cart.getcartQuantity());
	    
	    int rows = statement.executeUpdate();
	    return rows;
	}
	
    
//	 public List<Cart> getCartItems(ArrayList<Cart> cartList) throws SQLException {
//	        List<Cart> cart = new ArrayList<>();
//	            if (cartList.size() > 0) {
//	                for (Cart item : cartList) {
//	                    String query = "select * from products where id=?";
//	                    statement = conn.prepareStatement(query);	
//	                    statement.setInt(1, item.getId());
//	                    resultSet = statement.executeQuery();
//	                    while (resultSet.next()) {
//	                        Cart row = new Cart();
//	                        row.setId(resultSet.getInt("id"));
//	                        row.setProductName(resultSet.getString("ProductName"));
//	                        //total price after multiple quantity
//	                        row.setPrice(resultSet.getFloat("price")*item.getQuantity());
//	                        row.setQuantity(item.getQuantity());
//	                        cart.add(row);
//	                    }
//
//	                }
//	            } else {
//	            	System.out.println("empty list");
//	            }
//	        
//	        return cart;
//	 }
		
		public boolean checkCart(Cart cart) throws SQLException {
			
			boolean isFound = false;
			String query = "select productId from cart";
			statement = conn.prepareStatement(query);
			resultSet = statement.executeQuery();
			
			while(resultSet.next()) {
				int productIdFromDB = resultSet.getInt("productId");
				
				if(cart.getProductId() == productIdFromDB) {
					System.out.println("found");
					isFound = true;
					break;
				}
				
			}
			return isFound;
			
		}
}
