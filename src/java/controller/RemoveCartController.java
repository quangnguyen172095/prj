package controller;

import java.io.IOException;
import java.sql.ResultSet;

import entity.Order;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.DAOProduct;

/**
 * Servlet implementation class RemoveCartController
 */
@WebServlet("/RemoveCartController")
public class RemoveCartController extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Order order = (Order) session.getAttribute("order");
		int productId = Integer.parseInt(request.getParameter("productId").toString());
		order.removeItem(productId);
		
		DAOProduct dao = new DAOProduct();
		ResultSet rs = dao.getData("select distinct category_name from Products");
		request.setAttribute("productID", "");
		request.setAttribute("cRs", rs);
		request.getRequestDispatcher("Cart.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
