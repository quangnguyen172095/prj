package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

import entity.Customer;

public class DAOCustomer extends DBConnect {
	public Vector<Customer> getAll(String search) {
		Vector<Customer> vector = new Vector<Customer>();
		String sql = "select * from customers where "
				+ "customer_id like ? "
				+ "or first_name like ? "
				+ "or last_name like ? "
				+ "or phone like ? "
				+ "or email like ? "
				+ "or street like ? "
				+ "or city like ? "
				+ "or state like ? "
				+ "or zip_code like ?";
		try {
			PreparedStatement pre = conn.prepareStatement(sql);
			pre.setString(1, "%" + search + "%");
			pre.setString(2, "%" + search + "%");
			pre.setString(3, "%" + search + "%");
			pre.setString(4, "%" + search + "%");
			pre.setString(5, "%" + search + "%");
			pre.setString(6, "%" + search + "%");
			pre.setString(7, "%" + search + "%");
			pre.setString(8, "%" + search + "%");
			pre.setString(9, "%" + search + "%");
			ResultSet rs = pre.executeQuery();
			while (rs.next()) {
				vector.add(new Customer(rs.getInt("customer_id"), rs.getString("first_name"), rs.getString("last_name"), 
						rs.getString("phone"), rs.getString("email"), rs.getString("street"), 
						rs.getString("city"), rs.getString("state"), rs.getString("zip_code")));
			}
		} catch (SQLException ex) {
			Logger.getLogger(DAOProduct.class.getName()).log(Level.SEVERE, null, ex);
		}
		return vector;
	}
	
	public int getLastId() {
		String sql = "SELECT MAX(customer_id) FROM customers";
		try {
			ResultSet rs = getData(sql);

			while (rs.next()) {
				return rs.getInt(1);
			}
		} catch (SQLException ex) {
			Logger.getLogger(DAOCustomer.class.getName()).log(Level.SEVERE, null, ex);
		}
		return 1000;
	}
	
	public boolean addCustomer(Customer customer) {
		String sql = "INSERT INTO [dbo].[customers]\r\n"
				+ "           ([customer_id]\r\n"
				+ "		   	  ,[first_name]\r\n"
				+ "           ,[last_name]\r\n"
				+ "           ,[phone]\r\n"
				+ "           ,[email]\r\n"
				+ "           ,[street]\r\n"
				+ "           ,[city]\r\n"
				+ "           ,[state]\r\n"
				+ "           ,[zip_code])\r\n"
				+ "VALUES (?,?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, customer.getId());
			ps.setString(2, customer.getFirstName());
			ps.setString(3, customer.getLastName());
			ps.setString(4, customer.getPhone());
			ps.setString(5, customer.getEmail());
			ps.setString(6, customer.getStreet());
			ps.setString(7, customer.getCity());
			ps.setString(8, customer.getState());
			ps.setString(9, customer.getZipCode());
			
			return ps.execute(); 
		} catch (SQLException ex) {
			Logger.getLogger(DAOCustomer.class.getName()).log(Level.SEVERE, null, ex);
		}
		return false;
	}
}
