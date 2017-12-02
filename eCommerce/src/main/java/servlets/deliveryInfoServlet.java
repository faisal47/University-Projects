/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package servlets;

import dao.DataService;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pojo.DeliveryItem;

/**
 *
 * @author Nur Uddin
 */
@WebServlet(name = "deliveryInfoServlet", urlPatterns = {"/delivery/info"})
public class deliveryInfoServlet extends HttpServlet {

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
        DeliveryItem item = new DeliveryItem();
        
        item.setId(Integer.parseInt(request.getParameter("id")));
        item.setName(request.getParameter("name"));
        item.setPhoneNo(Integer.parseInt(request.getParameter("phone_no")));
        item.setDistrict(request.getParameter("district"));
        item.setUpaZilla(request.getParameter("upazilla"));
        item.setRoadNo(request.getParameter("road_no/vill."));
        item.setHouseNo(request.getParameter("house_no"));
        
        DataService dataService = new DataService();
        dataService.deliveryItemInsert(item);
        
        System.out.println("after item inserted in deliveryinfoservlet");
        
        response.sendRedirect(request.getContextPath()+"/order/confirm");
        
        //response.setContentType("text/html;charset=UTF-8");
        
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
        int id = Integer.parseInt(request.getParameter("id"));
        System.out.println(id);
        
        request.getRequestDispatcher("/deliveryInfo.jsp").forward(request, response);
        
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
