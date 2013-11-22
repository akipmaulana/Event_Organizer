/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controll;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.User;

/**
 *
 * @author Akip Maulana
 */
@WebServlet(name = "UserServlet", urlPatterns = {"/UserServlet"})
public class UserServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        User user = new User();
        try {
            String action = request.getParameter("action");
            if("add".equals(action)){
                response.sendRedirect("user/RegistrasiUser.jsp");
            }else if("ins".equals(action)){
                user.insertDataUser(request.getParameter("username"), request.getParameter("psword")
                        , request.getParameter("kl"), request.getParameter("hp")
                        , request.getParameter("email"), 0);
                response.sendRedirect("UserServlet");
            }else if("del".equals(action)){
                user.deleteDataUser(request.getParameter("id"));
                response.sendRedirect("UserServlet");
            }else if("edit".equals(action)){
                user.viewDataUser(Integer.parseInt(request.getParameter("id")));
                request.setAttribute("identitas", user);//melempar kelas atau object barang untuk melihat semua barang.
                request.getRequestDispatcher("user/EditUser.jsp").forward(request, response);
            }else if("update".equals(action)){
                user.updateDataUser(request.getParameter("id"), request.getParameter("psword")
                        , request.getParameter("kl"), request.getParameter("hp"), request.getParameter("email"), 0);
                response.sendRedirect("UserServlet");
            }else{
                user.viewAll();
                request.setAttribute("userlist", user);//melempar kelas atau object barang untuk melihat semua barang.
                request.getRequestDispatcher("user/ViewAllDataUser.jsp").forward(request, response);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
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
     * Handles the HTTP
     * <code>POST</code> method.
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
