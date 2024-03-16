/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;

import entity.Product;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.DAOProduct;

/**
 *
 * @author DELL
 */
public class ProductController extends HttpServlet {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            DAOProduct dao = new DAOProduct();
            String service = request.getParameter("service");
            if (service == null) {
                service = "displayAll";
            }
            if (service.equals("displayAll")) {
                //chuẩn bị dữ liệu: call DAO
                Vector<Product> vector = dao.getAll("");
                String title = "List of Product";
                // call jsp: set value --> view by jsp
                request.setAttribute("data", vector);
                request.setAttribute("title", title);
                // call jsp
                RequestDispatcher disp
                        = request.getRequestDispatcher("/DisplayProduct.jsp");
                // view
                disp.forward(request, response);
            }
            if (service.equals("update")) {
                //check submit ?
                String submit = request.getParameter("submit");
                if (submit == null) { // chua submit--> hien thi form
                    int id = Integer.parseInt(request.getParameter("id"));
                    //get update Product
                    Product pro = dao.findById(id);
                    //value update form
                    request.setAttribute("pro", pro);
                    //
                    disp(request, response, "/JSP/UpdateProduct.jsp");
                } else {// da submit --> update
                    String id = request.getParameter("pid");
                    //String name = request.getParameter("pname");
                    String modelYear = request.getParameter("model");
                    String listPrice = request.getParameter("price");
                    String brandName = request.getParameter("brand");
                    String categoryName = request.getParameter("cate");
                    //check value
                    //convert
                    int pid = Integer.parseInt(id);
                    int modelYearInt = Integer.parseInt(modelYear);
                    double listPriceDouble = Double.parseDouble(listPrice);
                    // object
                    Product pro = new Product(pid, brandName, modelYearInt,
                            listPriceDouble, brandName, categoryName);
                    dao.updateProduct(pro);
                   // disp(request, response,"ProductController");
                   response.sendRedirect("ProductController");
                }
            }
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet ProductController</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet ProductController at " + request.getContextPath() + "</h1>");
//            out.println("</body>");
//            out.println("</html>");
        }
    }

    public void disp(HttpServletRequest request, HttpServletResponse response,
            String url) throws ServletException, IOException {
        RequestDispatcher disp
                = request.getRequestDispatcher(url);
        // view
        disp.forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
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
