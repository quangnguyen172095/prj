package controller;

import java.io.IOException;
import java.util.Vector;

import entity.Order;
import entity.OrderItem;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.DAOBill;

/**
 * Servlet implementation class DetailBillController
 */
@WebServlet("/DetailBillController")
public class DetailBillController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int orderId = Integer.valueOf(request.getParameter("orderId").toString());
		DAOBill dao = new DAOBill();
		Vector<OrderItem> orderItems = dao.getOrderItemsById(orderId);
		Order order = dao.getOrderById(orderId);
		
		request.setAttribute("orderItems", orderItems);
		request.setAttribute("status", order.getOrderStatus());
		request.setAttribute("orderId", orderId);
		request.setAttribute("service", "bill");
		request.getRequestDispatcher("BillDetail.jsp").forward(request, response);
	}

}
