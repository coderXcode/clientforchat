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
import javax.servlet.http.HttpSession;

/**
 *
 * @author MansJ
 */
public class inbox extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    PreparedStatement ps=null;   
    Connection con=null;
    ResultSet rs=null;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
             
            HttpSession hs=request.getSession(false);
            /* TODO output your page here. You may use following sample code. */
            out.println(
"<!DOCTYPE html>\n" +
"<!--\n" +
"To change this license header, choose License Headers in Project Properties.\n" +
"To change this template file, choose Tools | Templates\n" +
"and open the template in the editor.\n" +
"-->\n" +
"<html style=\"  overflow-x: hidden;\">\n" +
"    <head>\n" +
"        <title>E-Mailer</title>\n" +
"        <meta charset=\"UTF-8\">\n" +
"        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
"        <link href=\"css/login.css\" rel=\"stylesheet\" type=\"text/css\" />\n" +
"        \n" +
"        \n" +
"    </head>\n" +
"\n" +
"    <body>\n" +
"        <!--<div id=\"load_screen\"><div id=\"loading\"><center><img src=\"addingGif.gif\"/></center></div></div>-->\n" +
"        <div id=\"div_1\" style=\"color: white;  height: 120px; width: 70px; background: red; float: left;\">\n" +
"            <h1 style=\"font-size:  72px;\">E-MAILER</h1> \n" +
"\n" +
"            <h6>we do things that connect...</h6>\n" +
"   \n" +
"        </div>\n" +
"        \n" +
"        <div id=\"div_2\" style=\"background-color:#01aed3; width: 370px;height:120px;\" >\n" +
"        </div>\n" +
"        <br style=\"clear: both;\"/>\n" +
"        <div style=\" padding-top: 50px;\"><h1>WELCOME</h1>\n" +"<h1> \n" +  hs.getAttribute("uniform")+"\n" +
"                " +
"                \n" +
"</h1>        \n" +
"         \n" +
"        \n" +
"        </div>\n" +
"        <div style=\"width: 340px;height: 1500px; background: wheat;float: left; border-radius: 40px;\">\n" +
"            <div style=\"width: 340px;height: 200px; border-radius: 20px; background:  #01aed3; padding-top: 40px;overflow:  scroll; color: white; \" > <h3> PEOPLE ONLINE...</h3></div>\n" +
"            <a href=\"/mailernass/inbox\">IN BOX</a>\n" +
"            <br/>\n" +
"            <a href=\"/mailernass/outbox\">OUT BOX</a>\n" +
"            <br/>\n" +
"            <a href=\"/mailernass/login.jsp\">COMPOSE</a>\n <br/>\n" +
"            <a href=\"/mailernass/conduit\">LOGOUT</a>   " +
"            </div><!--compose mail division-->\n" +
"                     \n" +
"            \n" +
"        \n" +
"                <div style=\"width: 900px;height: 1500px; background: papayawhip ;float:right; border-left: dotted;  border:  #120a09 solid; border-radius: 20px;\">\n" +
"                  <h3>HERE ARE YOUR IN BOX MESSAGES</h3>\n" +
"            <div style=\"width: 800px;height: 1400px;overflow: scroll; background: wheat; border-radius: 40px;padding-left: 20px;\">\n" +
"                       \n" +
"                    \n");  
            con=db.createConnection();
          
            String quer1="select * from MANAS."+hs.getAttribute("uniform");
            ps=con.prepareStatement(quer1);
            rs=ps.executeQuery();
            while(rs.next())
            {
                 if(rs.getString("TYPE").equalsIgnoreCase("inbox"))
                 {
                       out.println("<div style='width:700px;height:1400px; overflow:scroll; border:solid 2px;'>");
                       out.println("<h3 style='color:red;'>SUBJECT---"+rs.getString("SUBJECT")+"</h3>");
                       out.println("<h4 style='color:green;'>MESSAGE---"+rs.getString("MESSAGE")+"</h4");
                       out.println("<h4 style='color:black;'>by-----"+rs.getString("BYWHOM")+"</h4");
                       out.println("---------------------------------------------------------------------------------");
                        out.println("</div>");
                 }
                
                
                
            }
            
            
            out.println(   "                </div> <!-- in box division-->  \n" +
"    \n" +
"                </div>\n" +
"    </body>\n" +
"</html>\n" +
"");
            
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
