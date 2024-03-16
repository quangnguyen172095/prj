/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import entity.Product;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.ResultSet;
import java.util.Vector;
import model.DAOProduct;

/**
 *
 * @author DELL
 */
public class MainController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
	 * methods.
	 *
	 * @param request  servlet request
	 * @param response servlet response
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException      if an I/O error occurs
	 */
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		try (PrintWriter out = response.getWriter()) {
			/* TODO output your page here. You may use following sample code. */
			DAOProduct dao = new DAOProduct();
			String service = request.getParameter("service");
			String search = request.getParameter("search") == null ? "" : request.getParameter("search").toString().trim();
			if (service == null) {
				service = "displayAll";
			}
			if (service.equals("displayAll")) {
				Vector<Product> vector = dao.getAll(search);
				ResultSet rs = dao.getData("select distinct category_name from Products");
				request.setAttribute("productID", "All Products");
				request.setAttribute("search", search);
				request.setAttribute("cVector", vector);
				request.setAttribute("cRs", rs);
				RequestDispatcher dis = request.getRequestDispatcher("/index.jsp");
				dis.forward(request, response);
			}
			if (service.equals("displayProduct")) {
				String id = (String) request.getParameter("id");
				System.out.println(id);
				Vector<Product> vector = dao.findByCate(id, search);
				ResultSet rs = dao.getData("select distinct category_name from Products");
				request.setAttribute("productID", id);
				request.setAttribute("search", search);
				request.setAttribute("cVector", vector);
				request.setAttribute("cRs", rs);
				RequestDispatcher dis = request.getRequestDispatcher("/index.jsp");
				dis.forward(request, response);
			}
		}
	}

	// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the
	// + sign on the left to edit the code.">
	/**
	 * Handles the HTTP <code>GET</code> method.
	 *
	 * @param request  servlet request
	 * @param response servlet response
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException      if an I/O error occurs
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	/**
	 * Handles the HTTP <code>POST</code> method.
	 *
	 * @param request  servlet request
	 * @param response servlet response
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException      if an I/O error occurs
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	/**
	 * Returns a short description of the servlet.
	 *
	 * @return a String containing servlet description
	 */
	@Override
	public String getServletInfo() {
		return "Short description";
	}// </editor-fold>

}
