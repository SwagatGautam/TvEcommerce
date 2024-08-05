package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.User;
import utils.DbConnectivity;
import utils.PasswordHashing;

public class UserDAO {
	private Connection conn;
	private PreparedStatement statement;
	private boolean isSuccess;
	private ResultSet resultSet;
	private static final String insertQuery = "insert into user"
			+ "(fullName,email,phone,dob,gender,address,password,username)"
			+ "values(?,?,?,?,?,?,?,?)";
	
	public UserDAO() {
		conn = DbConnectivity.getDbConnection();
	}
	
	//check conditions an then add user into db
	public boolean addUser(User user) {
		
		String query = "select count(*) from user";
		try {
			statement = conn.prepareStatement(query);
			resultSet = statement.executeQuery();
			if(resultSet.next()) {
				
				
				if(checkUser(user)) {
					isSuccess = false;
				}
				else {
					int rows = insertUser(user);
					if(rows>0) {
						isSuccess=true;
					}
				}
				
				
			}
			else {
				int rows = insertUser(user);
				if (rows>0) {//means the data is inserted into database
					isSuccess=true;
				}
			}
				
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return isSuccess;
		
	}
	
	public int getIdByUsername(String username) throws SQLException {
	    statement = conn.prepareStatement("SELECT id FROM user WHERE username=?");
	    statement.setString(1, username);
	    resultSet = statement.executeQuery();
	    int id = -1;
	    if(resultSet.next()) {
	        id = resultSet.getInt("id");
	    }
	    return id;
	}
	
	//method to insert user data into db
	//query is instantiated 
	public int insertUser(User user) throws SQLException{
		
		statement = conn.prepareStatement(insertQuery);
		statement.setString(1, user.getFullName());
		statement.setString(2, user.getEmail());
		statement.setLong(3, user.getPhone());
		statement.setDate(4, user.getDob());
		statement.setString(5, user.getGender());
		statement.setString(6, user.getAddress());
		statement.setString(7, user.getPassword());
		statement.setString(8, user.getUsername());
		
		int rows = statement.executeUpdate();
		
		return rows;
	}
	
	//login
	public boolean userLogin(String username, String password) throws SQLException {
		statement = conn.prepareStatement("select username,password,role from user where username=?");
		statement.setString(1, username);
		resultSet = statement.executeQuery();
		boolean isSuccess = false;
		if (resultSet.next()) {
			String passwordFromDb = resultSet.getString("password");

			
			if (PasswordHashing.verifyPassword(password, passwordFromDb)) {
				isSuccess = true;
			} else {
				isSuccess = false;
			}

		}
		return isSuccess;

	}
	
	
	//checks if there is an existing user with similar 
	public boolean checkUser(User user) throws SQLException {
		
		boolean isFound = false;
		String query = "select email,phone,username from user";
		statement = conn.prepareStatement(query);
		resultSet = statement.executeQuery();
		
		while(resultSet.next()) {
			String emailFromDB = resultSet.getString("email");
			String usernameFromDB = resultSet.getString("username");
			long phoneFromDB = resultSet.getLong("phone");
			
			if(user.getEmail().equals(emailFromDB)) {
				isFound = true;
				break;
			}else if(user.getPhone()==phoneFromDB) {
				isFound = true;
				break;
			}else if(user.getUsername()==usernameFromDB) {
				isFound = true;
				break;
			}
			
		}
		return isFound;
		
	}
}
