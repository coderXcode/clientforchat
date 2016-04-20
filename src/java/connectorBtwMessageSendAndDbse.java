/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author MansJ
 */
public class connectorBtwMessageSendAndDbse extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    Connection con=null;
    PreparedStatement ps=null;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
    HttpSession hs=request.getSession(false);
            String uni=(String)hs.getAttribute("uniform"); //nicely done buddy u ROCK!!! 
           
            String to=request.getParameter("to");
              to=to.toUpperCase();
              String sub=request.getParameter("subject");
              String message=request.getParameter("message");
              String query1="insert into MANAS."+to+" values (?,?,?,?)"; // sub mes type by whom          
              int w=0;
              try{
              con=db.createConnection();
               ps=con.prepareStatement(query1);
               ps.setString(1,sub);
               ps.setString(2, message);
               ps.setString(3, "inbox");
               ps.setString(4, uni);
                out.println("yha");  
                w=ps.executeUpdate();
              }
              catch(Exception e)
              {
               out.println("champion");   
              }
               if(w>0)
               {
                   out.println("success12344");
               }
               
               else
               {response.sendRedirect("loginError.jsp");
                   out.println("unsuccessfull");
               }
               out.println("success12344");
               String query2="insert into MANAS."+uni+" values (?,?,?,?)";
               ps=con.prepareStatement(query2);
               ps.setString(1,sub);
               ps.setString(2, message);
               ps.setString(3, "outbox");
               ps.setString(4, to);  
                int w1=ps.executeUpdate();
               if(w1>0)
               {
                   out.println("success");
                   response.sendRedirect("loginSuccess.jsp");
               }
               out.println("unsuccessfull");
               
               
        }
        catch(Exception e)
        {
            System.out.println("you have done it finally");
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
