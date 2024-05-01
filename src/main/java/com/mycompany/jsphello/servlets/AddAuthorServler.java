/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.jsphello.servlets;

import com.mycompany.jsphello.data.DataInsert;
import com.mycompany.jsphello.data.Database;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Alex
 */
public class AddAuthorServler extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AddAuthorServler</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1> Створення нового автора </h1>");
            out.println("<form method=\"post\" action=\"\" >");
            out.println("<label for=\"first_name\">Ім'я:</label>");
            out.println("<input type=\"text\" id=\"first_name\" name=\"first_name\" />");
            out.println("<br>");
            out.println("<label for=\"last_name\">Прізвище:</label>");
            out.println("<input type=\"text\" id=\"last_name\" name=\"last_name\" />");
            out.println("<br>");
            out.println("<label for=\"middle_name\">По-батькові:</label>");
            out.println("<input type=\"text\" id=\"middle_name\" name=\"middle_name\" />");
            out.println("<br>");
            out.println("<input type=\"submit\" />");
            out.println("</form>");
            out.println("<a href=\"index.html\"> На головну</a>");
            out.println("</body>");
            out.println("</html>");
        }
    }
    
    protected void processPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String first_name = request.getParameter("first_name"); 
        String last_name = request.getParameter("last_name"); 
        String middle_name = request.getParameter("middle_name"); 
        Database db = new Database();
        Connection c = db.getConnection();
        DataInsert di = new DataInsert(c);
        boolean  result = di.insertAuthor(first_name, last_name, middle_name);
        String message;
        if(result){
        message ="Добвлено автора";
        }
        else {
        message = "Знову світло пропало";
        
        }
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AddAuthorServler</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>" + message + "</h1>");
            out.println("<a href=\"index.html\"> На головну</a>");
            out.println("</body>");
            out.println("</html>");
        }
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
        processGet(request, response);
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
        processPost(request, response);
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
