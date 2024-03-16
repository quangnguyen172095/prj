package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;

import entity.Bill;
import entity.Product;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.DAOBill;
import model.DAOProduct;

/**
 * Servlet implementation class CartController
 */
@WebServlet("/CartController")
public class CartController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		try (PrintWriter out = response.getWriter()) {
			DAOProduct dao = new DAOProduct();
			// chuẩn bị dữ liệu: call DAO
			Vector<Product> vector = dao.getAll("");
			String title = "List of Product";
			// call jsp: set value --> view by jsp
			request.setAttribute("data", vector);
			request.setAttribute("title", title);
			// call jsp
			RequestDispatcher disp = request.getRequestDispatcher("/CartEx.jsp");
			// view
			disp.forward(request, response);
		}
	}

	public void disp(HttpServletRequest request, HttpServletResponse response, String url)
			throws ServletException, IOException {
		RequestDispatcher disp = request.getRequestDispatcher(url);
		// view
		disp.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int orderId = Integer.valueOf(request.getParameter("orderId").toString());
		int status = Integer.valueOf(request.getParameter("status").toString());
		DAOBill dao = new DAOBill();		
		dao.updateStatusById(orderId, status);
		
		
		DAOBill dao2 = new DAOBill();
		Vector<Bill> bills = dao2.getAll("");
		request.setAttribute("service", "bill");
		request.setAttribute("bills", bills);
		RequestDispatcher dis = request.getRequestDispatcher("/admin.jsp");
		dis.forward(request, response);
	}

}
