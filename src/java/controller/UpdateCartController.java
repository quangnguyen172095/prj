package controller;

import java.io.IOException;
import java.sql.ResultSet;

import entity.Order;
import entity.OrderItem;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.DAOProduct;

/**
 * Servlet implementation class UpdateCartController
 */
@WebServlet("/UpdateCartController")
public class UpdateCartController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		Order order = (Order) session.getAttribute("order");
		for (OrderItem orderItem : order.getItems()) {
			int productId = orderItem.getProductId();
			int quantity = Integer.valueOf(request.getParameter(String.valueOf(productId)).toString());
			if (quantity < 0) {
				quantity = 0;
			}
			orderItem.setQuantity(quantity);
		}

		DAOProduct dao = new DAOProduct();
		ResultSet rs = dao.getData("select distinct category_name from Products");
		request.setAttribute("productID", "");
		request.setAttribute("cRs", rs);
		request.getRequestDispatcher("Cart.jsp").forward(request, response);
	}

}
