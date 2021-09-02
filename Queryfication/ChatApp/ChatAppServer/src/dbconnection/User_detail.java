package dbconnection;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Base64;

import javax.swing.JOptionPane;

public class User_detail {
	static String url = "jdbc:mysql://localhost:3306/chatapp";
	static String username = "root";
	static String password = "abc@123";
	Connection connection;
	
	public User_detail() {
		// TODO Auto-generated constructor stub
	
		try {
			connection = DriverManager.getConnection(url,username,password);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public void RegisterUser(String name, String password, String regno , String phoneno,String email )
	{
		String query = "INSERT INTO userdetails(Name,Password,RegNo,PhoneNo,Email) VALUES(?,?,?,?,?)";
		try {
			PreparedStatement pa = connection.prepareStatement(query);
			pa.setString(1,name);
			pa.setString(2,Base64.getEncoder().encodeToString(password.getBytes()));
			pa.setString(3,regno);
			pa.setString(4,phoneno);
			pa.setString(5, email);
			int i = pa.executeUpdate();
			if (i>0) {
				JOptionPane.showMessageDialog(null, "REGISTERED");
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.toString());
		}
	}


	
	public boolean LoginUser(String name , String password)
	{
		String query = "SELECT * FROM userdetails WHERE Name = '"+name+"' and Password = '"+Base64.getEncoder().encodeToString(password.getBytes())+"'";
		
		java.sql.Statement st;
		try {
			st = connection.createStatement();
			ResultSet set = st.executeQuery(query);
			if (!set.next()) {
				return false;
			}
			else
			{
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
		
	}



}