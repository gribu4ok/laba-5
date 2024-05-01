/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.jsphello.servlets;

import com.mycompany.jsphello.data.Author;
import com.mycompany.jsphello.data.DataExtractor;
import com.mycompany.jsphello.data.Database;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Alex
 */
public class ListAuthorsServlet extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ListAuthorsServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ListAuthorsServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    protected void processListAuthor(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        Database db = new Database();
        Connection c = db.getConnection();
        DataExtractor de = new DataExtractor(c);
        ArrayList<Author> authors = de.getData();
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ListAuthorsServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ListAuthorsServlet at " + request.getContextPath() + "</h1>");
            out.println("<table>");
            out.println("<tr><th>id</th><th>first_name</th><th>last_name</th><th>middle_name</th></tr>");
            for (int i = 0; i < authors.size(); i++) {
                out.println("<tr>");
                String item;
                item = String.format("<td> %1$d </td> <td> %2$s </td> <td> %3$s </td> <td> %4$s </td>", authors.get(i).getId(),
                        authors.get(i).getFirst_name(),
                        authors.get(i).getLast_name(),
                        authors.get(i).getMiddle_name());
                out.println(item);
                out.println("</tr>");
            }
            out.println("</table>");
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
        processListAuthor(request, response);
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
