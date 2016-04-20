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
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author MansJ
 */
public class login extends HttpServlet {

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
            String uadd=request.getParameter("address");
             String unumb=request.getParameter("number");
              String umail=request.getParameter("email");
            con=db.createConnection();
           System.out.println("here 1");
            String inLogin="";
           try{
           inLogin="Insert into MANAS.LOGIN values (?,?,?,?,?)";
           System.out.println("here 2");
           ps=con.prepareStatement(inLogin);
           System.out.println("here 3");
           ps.setString(1,uname);
            ps.setString(2,upass);
            ps.setString(3,uadd);
            ps.setString(4,unumb);
            ps.setString(5,umail);
           System.out.println("here 4");
            int u=ps.executeUpdate();
           }
           catch(SQLException e)
           {
             out.println("jjij");
             response.sendRedirect("existinguserindex.html");
           }
           
           inLogin="Insert into MANAS.USERLOGIN values (?,?)";
           System.out.println("here 2");
           ps=con.prepareStatement(inLogin);
           System.out.println("here 3");
           ps.setString(1,uname);
            ps.setString(2,upass);
            int u=ps.executeUpdate();
           
            if(u>0)
            {
                 out.println("success"+uname);
                String query ="CREATE TABLE "+ uname+" (SUBJECT VARCHAR(70),MESSAGE VARCHAR(300),TYPE VARCHAR(20),BYWHOM VARCHAR(50))";
                   // con=db.createConnection();
                out.println("hereee");    
                PreparedStatement ps1=con.prepareStatement(query);
                out.println("hereee7788");   
                ps1.execute();
                inLogin="Insert into MANAS."+uname+" values (?,?,?,?)";
           System.out.println("here 2");
           ps=con.prepareStatement(inLogin);
           System.out.println("here 3");
           ps.setString(1,"welcome message");
           out.println("yo");
            ps.setString(2,"we welcome u to emailer we are glad to have you here");
           out.println("yo22");
            ps.setString(3,"inbox");
            ps.setString(4,"adminS");
            u=ps.executeUpdate();
                
                
     
               response.sendRedirect("index.html");
              
            }
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
