/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author MansJ
 */
public class UserLogin extends HttpServlet {
Connection con=null;
PreparedStatement ps=null;
ResultSet rs=null;
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
           String uname=request.getParameter("username");
            String upass=request.getParameter("pass");
            String sql2="select * from MANAS.USERLOGIN";
            con=db.createConnection();
            ps=con.prepareStatement(sql2);
            rs=ps.executeQuery();
             HttpSession hs1=request.getSession(true);
             hs1.invalidate();
            while(rs.next())
            {
                if(rs.getString("USERNAME").equals(uname) && rs.getString("PASSWORD").equals(upass))
                {
                    out.println("got it");
                   HttpSession hs=request.getSession();
                  // hs.setAttribute("test", "test");
                  hs.setAttribute("uniform", uname);
                   String test = "test";
request.setAttribute("test", uname);
  
request.getRequestDispatcher("/login.jsp").forward(request, response);
                }
                else
                {
                    out.println("didnt");
                }
            }
              response.sendRedirect("indexInvalid.html");
        }
        catch(SQLException e)
        {
         
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
