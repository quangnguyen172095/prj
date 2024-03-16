package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import entity.User;

public class DAOUser extends DBConnect {
	public User findByUsernameAndPassword(String username, String password) {
		User user = null;
		String sql = "select username,\r\n"
				+ "	case when users.customer_id is null then staffs.first_name + ' ' + staffs.last_name\r\n"
				+ "	else customers.first_name + ' ' + customers.last_name end as displayname,\r\n"
				+ "	customers.customer_id,\r\n" + "	staffs.staff_id\r\n" + "from users\r\n"
				+ "left join customers on users.customer_id = customers.customer_id\r\n"
				+ "left join staffs on users.staff_id = staffs.staff_id\r\n" + "where username = ? and password = ?";
		try {
			PreparedStatement pre = conn.prepareStatement(sql);
			pre.setString(1, username);
			pre.setString(2, password);
			ResultSet rs = pre.executeQuery();
			
			while (rs.next()) {
				user = new User (rs.getString("username"), rs.getString("displayname"), rs.getInt("customer_id"), rs.getInt("staff_id"));
			}
		} catch (SQLException ex) {
			Logger.getLogger(DAOUser.class.getName()).log(Level.SEVERE, null, ex);
		}
		return user;
	}
	
	public User findByUsername(String username) {
		User user = null;
		String sql = "select * from users where username = ?";
		try {
			PreparedStatement pre = conn.prepareStatement(sql);
			pre.setString(1, username);
			ResultSet rs = pre.executeQuery();
			
			while (rs.next()) {
				user = new User (rs.getString("username"), "", rs.getInt("customer_id"), rs.getInt("staff_id"));
				System.out.println(user.toString());
			}
		} catch (SQLException ex) {
			Logger.getLogger(DAOUser.class.getName()).log(Level.SEVERE, null, ex);
		}
		return user;
	}
	
	public boolean addCustomerUser(String username, String password, int customerId) {
		String sql = "INSERT INTO [dbo].[users]\r\n"
				+ "           ([username]\r\n"
				+ "           ,[password]\r\n"
				+ "           ,[customer_id]\r\n"
				+ "           ,[staff_id])\r\n"
				+ "VALUES(?,?,?,NULL)";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			ps.setInt(3, customerId);
			
			return ps.execute(); 
		} catch (SQLException ex) {
			Logger.getLogger(DAOCustomer.class.getName()).log(Level.SEVERE, null, ex);
		}
		return false;
	}
}
