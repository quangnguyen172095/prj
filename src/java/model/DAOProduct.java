/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import entity.Product;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DELL
 */
public class DAOProduct extends DBConnect {

	public Vector<Product> getAll(String search) {
		Vector<Product> vector = new Vector<Product>();
		String sql = "select * from products where product_name like ? or product_id like ? or brand_name like ? or category_name like ?";
		try {
			PreparedStatement pre = conn.prepareStatement(sql);
			pre.setString(1, "%" + search + "%");
			pre.setString(2, "%" + search + "%");
			pre.setString(3, "%" + search + "%");
			pre.setString(4, "%" + search + "%");
			ResultSet rs = pre.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("product_id"); // int id=rs.getInt(1);
				String pname = rs.getString(2); // String name=rs.getString("product_name");
				int year = rs.getInt(3);
				double price = rs.getDouble(4);
				String brand = rs.getString(5);
				String cate = rs.getString(6);
				Product pro = new Product(id, pname, year, price, brand, cate);
				vector.add(pro);
			}
		} catch (SQLException ex) {
			Logger.getLogger(DAOProduct.class.getName()).log(Level.SEVERE, null, ex);
		}
		return vector;
	}

	public Vector<Product> findByName(String name) {
		Vector<Product> vector = new Vector<Product>();
		String sql = "select * from products where product_name like '%" + name + "%'";
		ResultSet rs = getData(sql);
		try {
			while (rs.next()) {
				int id = rs.getInt("product_id"); // int id=rs.getInt(1);
				String pname = rs.getString(2); // String name=rs.getString("product_name");
				int year = rs.getInt(3);
				double price = rs.getDouble(4);
				String brand = rs.getString(5);
				String cate = rs.getString(6);
				Product pro = new Product(id, pname, year, price, brand, cate);
				vector.add(pro);
			}
		} catch (SQLException ex) {
			Logger.getLogger(DAOProduct.class.getName()).log(Level.SEVERE, null, ex);
		}
		return vector;
	}

	public Vector<Product> findByCate(String name, String search) {
		Vector<Product> vector = new Vector<Product>();
		String sql = "select * from products where category_name ='" + name + "' and product_name like '%" + search + "%'";
		ResultSet rs = getData(sql);
		try {
			while (rs.next()) {
				int id = rs.getInt("product_id"); // int id=rs.getInt(1);
				String pname = rs.getString(2); // String name=rs.getString("product_name");
				int year = rs.getInt(3);
				double price = rs.getDouble(4);
				String brand = rs.getString(5);
				String cate = rs.getString(6);
				Product pro = new Product(id, pname, year, price, brand, cate);
				vector.add(pro);
			}
		} catch (SQLException ex) {
			Logger.getLogger(DAOProduct.class.getName()).log(Level.SEVERE, null, ex);
		}
		return vector;
	}

	public Product findById(int pid) {
		Product pro = null;
		String sql = "select * from products where product_id=" + pid;
		ResultSet rs = getData(sql);
		try {
			while (rs.next()) {
				int id = rs.getInt("product_id"); // int id=rs.getInt(1);
				String pname = rs.getString(2); // String name=rs.getString("product_name");
				int year = rs.getInt(3);
				double price = rs.getDouble(4);
				String brand = rs.getString(5);
				String cate = rs.getString(6);
				pro = new Product(id, pname, year, price, brand, cate);
			}
		} catch (SQLException ex) {
			Logger.getLogger(DAOProduct.class.getName()).log(Level.SEVERE, null, ex);
		}
		return pro;
	}

	public int addProduct(Product pro) {
		int n = 0;
		String sql = "INSERT INTO [products]\n" + "           ([product_id]\n" + "           ,[product_name]\n"
				+ "           ,[model_year]\n" + "           ,[list_price]\n" + "           ,[brand_name]\n"
				+ "           ,[category_name])\n" + "     VALUES\n" + "           (" + pro.getProductId() + ",'"
				+ pro.getProductName() + "'," + pro.getModelYear() + "," + pro.getListPrice() + ",'"
				+ pro.getBrandName() + "','" + pro.getCategoryName() + "')";
		// System.out.println(sql);
		try {
			Statement state = conn.createStatement();
			n = state.executeUpdate(sql);
		} catch (SQLException ex) {
			Logger.getLogger(DAOProduct.class.getName()).log(Level.SEVERE, null, ex);
		}

		return n;
	}

	public int updateProduct(Product pro) {
		int n = 0;
		String sql = "UPDATE [products]\n" + "   SET [product_name] = ?" + "      ,[model_year] = ?"
				+ "      ,[list_price] = ?" + "      ,[brand_name] = ?" + "      ,[category_name] = ?"
				+ " WHERE [product_id]=?";
		try {
			PreparedStatement pre = conn.prepareStatement(sql);
			pre.setString(1, pro.getProductName());
			pre.setInt(2, pro.getModelYear());
			pre.setDouble(3, pro.getListPrice());
			pre.setString(4, pro.getBrandName());
			pre.setString(5, pro.getCategoryName());
			pre.setInt(6, pro.getProductId());
			n = pre.executeUpdate();
		} catch (SQLException ex) {
			Logger.getLogger(DAOProduct.class.getName()).log(Level.SEVERE, null, ex);
		}
		return n;
	}

	public int updatePrice(int id, double price) {
		int n = 0;
		return n;
	}

	public int addProductUsePre(Product pro) {
		int n = 0;
		String sql = "INSERT INTO [products]\n" + "           ([product_id]\n" + "           ,[product_name]\n"
				+ "           ,[model_year]\n" + "           ,[list_price]\n" + "           ,[brand_name]\n"
				+ "           ,[category_name])\n" + "     VALUES(?,?,?,?,?,?)";
		try {
			PreparedStatement pre = conn.prepareStatement(sql);
			// set parameter: pre.setDataType(index,para);
			// index start from 1
			pre.setInt(1, pro.getProductId());
			pre.setString(2, pro.getProductName());
			pre.setInt(3, pro.getModelYear());
			pre.setDouble(4, pro.getListPrice());
			pre.setString(5, pro.getBrandName());
			pre.setString(6, pro.getCategoryName());
			n = pre.executeUpdate();
		} catch (SQLException ex) {
			Logger.getLogger(DAOProduct.class.getName()).log(Level.SEVERE, null, ex);
		}

		return n;
	}

	public int removeProduct(int id) {
		int n = 0; // toan ven khoa ngoai
		// check foreign key value
		ResultSet rsStock = getData("select * from Stocks where product_id=" + id);
		ResultSet rsOrdItem = getData("select * from order_items where product_id=" + id);
		try {
			if (!(rsOrdItem.next() || rsStock.next())) {
				Statement state = conn.createStatement();
				n = state.executeUpdate("delete from Products where product_id=" + id);
			}
		} catch (SQLException ex) {
			// return -1;
			n = -1; // loi cau lenh
			ex.printStackTrace();
		}
		return n;
	}

	public void displayAll() {
		String sql = "select * from products";
		try {
			// Statement default
			// Statement state=conn.createStatement();
			// statement type 4
			Statement state = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			// run and get
			ResultSet rs = state.executeQuery(sql);
			while (rs.next()) {
				int id = rs.getInt("product_id"); // int id=rs.getInt(1);
				String name = rs.getString(2); // String name=rs.getString("product_name");
				int year = rs.getInt(3);
				double price = rs.getDouble(4);
				String brand = rs.getString(5);
				String cate = rs.getString(6);
				// entity
				Product pro = new Product(id, name, year, price, brand, cate);
				System.out.println(pro);
			}
		} catch (SQLException ex) {
			Logger.getLogger(DAOProduct.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public static void main(String[] args) {
		DAOProduct dao = new DAOProduct();
		// dao.displayAll();
//        Vector<Product> vector=dao.findByName("Trek");
//        for (Product product : vector) {
//            System.out.println(product);
//        }
//        Product pro = new Product(1003, "iphone 15", 2024, 2000, "apple", "mobile");
//        int n = dao.addProductUsePre(pro);
//        if (n > 0) {
//            System.out.println("inserted");
//        }
		int n = dao.removeProduct(1000);
		if (n > 0) {
			System.out.println("removed");
		} else if (n == -1) {
			System.out.println("error");
		}

	}
}
