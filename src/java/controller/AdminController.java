package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;

import entity.Bill;
import entity.Customer;
import entity.Product;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.DAOBill;
import model.DAOCustomer;
import model.DAOProduct;

/**
 * Servlet implementation class AdminController
 */
@WebServlet("/AdminController")
public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		try (PrintWriter out = response.getWriter()) {
			String service = request.getParameter("service");
			String search = request.getParameter("search") == null ? "" : request.getParameter("search").toString().trim();
			if (service == null) {
				service = "customer";
			}
			if (service.equals("customer")) {
				DAOCustomer dao = new DAOCustomer();
				Vector<Customer> customers = dao.getAll(search);
				request.setAttribute("service", "customer");
				request.setAttribute("search", search);
				request.setAttribute("customers", customers);
				RequestDispatcher dis = request.getRequestDispatcher("/admin.jsp");
				dis.forward(request, response);
			}
			if (service.equals("product")) {
				DAOProduct dao = new DAOProduct();
				Vector<Product> products = dao.getAll(search);
				request.setAttribute("service", "product");
				request.setAttribute("search", search);
				request.setAttribute("products", products);
				RequestDispatcher dis = request.getRequestDispatcher("/admin.jsp");
				dis.forward(request, response);
			}
			if (service.equals("bill")) {
				DAOBill dao = new DAOBill();
				Vector<Bill> bills = dao.getAll(search);
				request.setAttribute("service", "bill");
				request.setAttribute("search", search);
				request.setAttribute("bills", bills);
				RequestDispatcher dis = request.getRequestDispatcher("/admin.jsp");
				dis.forward(request, response);
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
