/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author MansJ
 */
public class as extends HttpServlet {

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
            String t=(String)request.getAttribute("test");
            String t1=request.getParameter("message");
            request.setAttribute("test", t);
  request.setAttribute("test1", t1);
request.getRequestDispatcher("/connectorBtwMessageSendAndDbse").forward(request, response);
            /* TODO output your page here. You may use following sample code. */
           out.println("<%@page import=\"java.sql.ResultSet\"%>\n" +
"<%@page import=\"java.sql.PreparedStatement\"%>\n" +
"<%@page import=\"java.sql.Connection\"%>\n" +
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
"\n" +
"        </div>\n" +
"        \n" +
"        <div id=\"div_2\" style=\"background-color:#01aed3; width: 370px;height:120px;\" >\n" +
"        </div>\n" +
"        <br style=\"clear: both;\"/>\n" +
"        <div style=\" padding-top: 50px;\"><h1>WELCOME</h1>\n" +
"            <h1>" +  request.getAttribute("test")+ "</h1>        \n" +
"        \n" +
"        \n" +
"        </div>\n" +
"        <div style=\"width: 340px;height: 1500px; background: wheat;float: left; border-radius: 40px;\">\n" +
"            <div style=\"width: 340px;height: 200px; border-radius: 20px; background:  #01aed3; padding-top: 40px;overflow:  scroll; color: white; \" > <h3> PEOPLE ONLINE...</h3></div>\n" +
"            <h3>YOU CAN COMPOSE MAIL TO ANY OF ABOVE MENTIONED USERS HERE</h3>\n" +
"            <div style=\"width: 340px;height: 300px; background: wheat;float: left; border-radius: 40px;\">\n" +
"                <form action=\"connectorBtwMessageSendAndDbse\" method=\"post\" >  <!-- remember to do a link-->\n" +
"                <label>TO WHOM*mandatory</label>\n" +
"                <br/>\n" +
"                <input type=\"text\" name=\"to\"/>\n" +
"                <br/>\n" +
"                    <label>SUBJECT*mandatory</label>\n" +
"                <br/>\n" +
"                <input type=\"text\" name=\"subject\"/>\n" +
"                <br/>\n" +
"                \n" +
"                <label>MESSAGE*mandatory</label>\n" +
"                <br/>\n" +
"                <textarea name=\"message\" cols=\"30\" rows=\"4\" style=\" overflow: scroll;\"></textarea>\n" +
"                <br/>\n" +
"                 <label>YOUR USERNAME*MANDATORY</label>\n" +
"                <br/>\n" +
"                <input type=\"text\" name=\"user\"/>\n" +
"                <br/>\n" +
"                <%\n" +
"             ;\n" +
"  \n" +
"             " +
"                \n" +
"                \n" +
"                %>\n" +
"                <input type=\"submit\" value=\"send\"/>\n" +
"                </form>\n" +
"            </div><!--compose mail division-->\n" +
"                     \n" +
"            \n" +
"        </div> \n" +
"        <div style=\"width: 900px;height: 1500px; background: papayawhip ;float:right; border-left: dotted;  border:  #120a09 solid; border-radius: 20px;\"></div>  \n" +
"    \n" +
"    \n" +
"    </body>\n" +
"</html>\n" +
"");
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
