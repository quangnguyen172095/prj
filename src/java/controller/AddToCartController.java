package controller;

import java.io.IOException;
import java.sql.ResultSet;

import entity.Order;
import entity.Product;
import entity.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.DAOProduct;

/**
 * Servlet implementation class AddToCartController
 */
@WebServlet("/AddToCartController")
public class AddToCartController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		if (user == null) {
			response.sendRedirect("LoginController");
			return;
		}
		
		DAOProduct dao = new DAOProduct();
		ResultSet rs = dao.getData("select distinct category_name from Products");
		request.setAttribute("productID", "");
		request.setAttribute("cRs", rs);
		request.getRequestDispatcher("Cart.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		if (user == null) {
			response.sendRedirect("LoginController");
			return;
		}

		Order order = (Order) session.getAttribute("order");

		if (order == null) {
			order = new Order();
			order.setCustomerId(user.getCustomerID());
		}
		
		//Add item to cart
		int productId = Integer.parseInt(request.getParameter("productId").toString());
		Product p = new DAOProduct().findById(productId);
		order.addItems(p);
		
		session.setAttribute("order", order);
		response.sendRedirect("MainController");
	}

}
