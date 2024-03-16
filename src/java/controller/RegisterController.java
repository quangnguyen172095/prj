package controller;

import java.io.IOException;

import entity.Customer;
import entity.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.DAOCustomer;
import model.DAOUser;

/**
 * Servlet implementation class RegisterController
 */
@WebServlet("/RegisterController")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("Register.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String street = request.getParameter("street");
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		String zipcode = request.getParameter("zipcode");
		
		User user = new DAOUser().findByUsername(username);
		if (user != null) {
			request.setAttribute("registerMes", "This username existed! Try again!");
			request.setAttribute("username", username);
			request.setAttribute("password", password);
			request.setAttribute("firstName", firstName);
			request.setAttribute("lastName", lastName);
			request.setAttribute("phone", phone);
			request.setAttribute("email", email);
			request.setAttribute("street", street);
			request.setAttribute("city", city);
			request.setAttribute("state", state);
			request.setAttribute("zipcode", zipcode);
			request.getRequestDispatcher("Register.jsp").forward(request, response);
			return;
		}
		
		DAOCustomer daoCustomer = new DAOCustomer();
		int id = daoCustomer.getLastId() + 1;
		daoCustomer.addCustomer(new Customer(id, firstName, lastName, phone, email, street, city, state, zipcode));
		new DAOUser().addCustomerUser(username, password, id);
		
		response.sendRedirect("MainController");
	}

}
