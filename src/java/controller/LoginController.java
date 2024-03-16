package controller;

import java.io.IOException;

import entity.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.DAOUser;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("Login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username").toString();
		String password = request.getParameter("password").toString();
		User user = new DAOUser().findByUsernameAndPassword(username, password);
		if (user == null) {
			request.setAttribute("loginMes", "Your username or password incorrect!<br/> Try again!");
			request.getRequestDispatcher("Login.jsp").forward(request, response);
			return;
		}
		HttpSession session = request.getSession();
		session.setAttribute("user", user);
		if (user.getCustomerID() == 1) {
			response.sendRedirect("MainController?service=displayAll");
		} else {
			response.sendRedirect("AdminController");
		}
	}

}
