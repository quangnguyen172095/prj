package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

import entity.Bill;
import entity.Order;
import entity.OrderItem;

public class DAOBill extends DBConnect {
	public Vector<Bill> getAll(String search) {
		Vector<Bill> vector = new Vector<Bill>();
		String sql = "select o.order_id, c.first_name, c.last_name, o.order_date, o.order_status,\r\n"
				+ "	sum(oi.quantity * oi.list_price) as total\r\n"
				+ "from orders o inner join customers c on o.order_id = c.customer_id\r\n"
				+ "	inner join order_items oi on o.order_id = oi.order_id\r\n"
				+ "where o.order_id like ? or c.first_name like ? or c.last_name like ?\r\n"
				+ "group by o.order_id, c.first_name, c.last_name, o.order_date, o.order_status";
		try {
			PreparedStatement pre = conn.prepareStatement(sql);
			pre.setString(1, "%" + search + "%");
			pre.setString(2, "%" + search + "%");
			pre.setString(3, "%" + search + "%");
			ResultSet rs = pre.executeQuery();
			while (rs.next()) {
				vector.add(new Bill(rs.getInt("order_id"), rs.getString("first_name") + " " + rs.getString("last_name"),
						rs.getDate("order_date").toString(), rs.getDouble("total"), rs.getInt("order_status")));
			}
		} catch (SQLException ex) {
			Logger.getLogger(DAOProduct.class.getName()).log(Level.SEVERE, null, ex);
		}
		return vector;
	}

	public int getLastId() {
		String sql = "SELECT MAX(order_id) AS a FROM orders";
		try {
			ResultSet rs = getData(sql);

			while (rs.next()) {
				return rs.getInt(1);
			}
		} catch (SQLException ex) {
			Logger.getLogger(DAOCustomer.class.getName()).log(Level.SEVERE, null, ex);
		}
		return 2000;
	}

	public void insertOrder(Order order, int customerId) {
		String sql = "INSERT INTO [dbo].[orders]\r\n" + "           ([order_id]\r\n" + "           ,[customer_id]\r\n"
				+ "           ,[order_status]\r\n" + "           ,[order_date]\r\n" + "           ,[required_date]\r\n"
				+ "           ,[shipped_date]\r\n" + "           ,[store_id]\r\n" + "           ,[staff_id])\r\n"
				+ "VALUES(?,?,1,CAST(GETDATE() AS DATE),CAST(GETDATE() AS DATE),CAST(GETDATE() AS DATE),1,1)";
		int orderId = getLastId() + 1;
		try {
			PreparedStatement pre = conn.prepareStatement(sql);
			pre.setInt(1, orderId);
			pre.setInt(2, customerId);
			pre.execute();
		} catch (SQLException ex) {
			Logger.getLogger(DAOProduct.class.getName()).log(Level.SEVERE, null, ex);
		}

		// Insert order item
		sql = "INSERT INTO [dbo].[order_items]\r\n" + "           ([order_id]\r\n" + "           ,[item_id]\r\n"
				+ "           ,[product_id]\r\n" + "           ,[quantity]\r\n" + "           ,[list_price]\r\n"
				+ "           ,[discount])\r\n" + "VALUES(?,?,?,?,?,?)";
		try {
			PreparedStatement pre = conn.prepareStatement(sql);
			for (int i = 0; i < order.getItems().size(); i++) {
				OrderItem item = order.getItems().get(i);
				pre.setInt(1, orderId);
				pre.setInt(2, i + 1);
				pre.setInt(3, item.getProductId());
				pre.setInt(4, item.getQuantity());
				pre.setDouble(5, item.getPrice());
				pre.setDouble(6, 1f);
				pre.execute();
			}
		} catch (SQLException ex) {
			Logger.getLogger(DAOProduct.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
	
	public Vector<OrderItem> getOrderItemsById(int orderId) {
		Vector<OrderItem> vector = new Vector<OrderItem>();
		String sql = "SELECT OI.item_id, OI.product_id, P.product_name, quantity, P.list_price, discount\r\n"
				+ "FROM order_items OI INNER JOIN products P ON OI.product_id = P.product_id\r\n"
				+ "WHERE order_id = ?";
		try {
			PreparedStatement pre = conn.prepareStatement(sql);
			pre.setInt(1, orderId);
			ResultSet rs = pre.executeQuery();
			while (rs.next()) {
				vector.add(new OrderItem(rs.getInt("item_id"), rs.getString("product_name"),
						rs.getInt("quantity"), rs.getDouble("list_price"), rs.getDouble("discount")));
			}
		} catch (SQLException ex) {
			Logger.getLogger(DAOProduct.class.getName()).log(Level.SEVERE, null, ex);
		}
		return vector;
	}
	
	public Order getOrderById(int orderId) {
		Order order = new Order();
		String sql = "SELECT * FROM orders WHERE order_id = ?";
		try {
			PreparedStatement pre = conn.prepareStatement(sql);
			pre.setInt(1, orderId);
			ResultSet rs = pre.executeQuery();
			while (rs.next()) {
				order.setId(rs.getInt("order_id"));
				order.setOrderStatus(rs.getInt("order_status"));
			}
		} catch (SQLException ex) {
			Logger.getLogger(DAOProduct.class.getName()).log(Level.SEVERE, null, ex);
		}
		return order;
	}
	
	public void updateStatusById(int orderId, int status) {
		String sql = "UPDATE orders\r\n"
				+ "SET order_status = ?\r\n"
				+ "WHERE order_id = ?";
		try {
			PreparedStatement pre = conn.prepareStatement(sql);
			pre.setInt(1, status);
			pre.setInt(2, orderId);
			pre.execute();
		} catch (SQLException ex) {
			Logger.getLogger(DAOProduct.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}
