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
import model.Events_model;

/**
 *
 * @author Akip Maulana
 */
@WebServlet(name = "Events_ctrl", urlPatterns = {"/Events_ctrl"})
public class Events_ctrl extends HttpServlet {

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
        String action = request.getParameter("action");
        Events_model event = new Events_model();
        try {
            if ("add".equals(action)) {
                response.sendRedirect("event/addEvent.jsp");
            } else if ("ins".equals(action)) {
                String name_event = request.getParameter("name_event");
                String start_date = request.getParameter("begin");
                String finish_date = request.getParameter("end");
                int quota = Integer.parseInt(request.getParameter("quota"));
                String desc = request.getParameter("desc");
                int user_id = Integer.parseInt(request.getParameter("user_id"));
                event.insert_Event(name_event, start_date, finish_date, quota, desc, user_id);
                response.sendRedirect("Events_ctrl");
            } else if ("del".equals(action)) {
                int event_id = Integer.parseInt(request.getParameter("id"));
                event.delete_Events(event_id);
                response.sendRedirect("Events_ctrl");
            } else if ("edit".equals(action)) {
                int event_id = Integer.parseInt(request.getParameter("id"));
                event.getData(event_id);
                request.setAttribute("event", event);//melempar kelas atau object barang untuk melihat semua barang.
                request.getRequestDispatcher("event/editEvent.jsp").forward(request, response);
            } else if ("update".equals(action)) {
                int event_id = Integer.parseInt(request.getParameter("event_id"));
                String name_event = request.getParameter("name_event");
                String start_date = request.getParameter("begin");
                String finish_date = request.getParameter("end");
                int quota = Integer.parseInt(request.getParameter("quota"));
                String desc = request.getParameter("desc");
                event.update_Events(name_event, start_date, finish_date, quota, desc, event_id);
                response.sendRedirect("Events_ctrl");
            } else {
                event.getAll();
                request.setAttribute("events", event);//melempar kelas atau object barang untuk melihat semua barang.
                request.getRequestDispatcher("event/viewAllEvent.jsp").forward(request, response);
            }
            
        } catch (Exception e) {            
            e.printStackTrace();
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
