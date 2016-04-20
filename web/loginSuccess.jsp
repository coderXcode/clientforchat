<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html style="  overflow-x: hidden;">
    <head>
        <title>E-Mailer</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="css/login.css" rel="stylesheet" type="text/css" />
        <script>
  
    function check()
            {
                alert("hu");
                //return false;
                
                 var ck_name = /^[A-Za-z0-9]{1,20}$/;
                var ck_message=/^[A-Za-z0-9!@#$%^&*()_ ]{3,40}$/;
                var ck_subject = /^[A-Za-z0-9!@#$%^&*()_ ]{1,20}$/;
               var name=document.getElementById("username2").value;
        alert(name);       
        var subject=document.getElementById("subject2").value;
       alert(subject);
        var message=document.getElementById("message2").value;
         alert(message);
        if(!name.match(ck_name))
{  alert("truen");
    document.getElementById("username2").setAttribute("style","background: #ed5454;color:white;");
    document.getElementById("username1").innerHTML = "Username should not have spaces and special char**";
     document.getElementById("subject2").setAttribute("style","background:bisque;color:black;");
   document.getElementById("message2").setAttribute("style","background: bisque;color:black;");
    document.getElementById("subject1").innerHTML = "Subject:";
      document.getElementById("message1").innerHTML = "Message:";
       
            return false;
}  
  else if(!subject.match(ck_subject))
{  alert("truen2");
    document.getElementById("subject2").setAttribute("style","background: #ed5454;color:white;");
    document.getElementById("subject1").innerHTML = "Subject should not be blank and 1-20 length";
     document.getElementById("username2").setAttribute("style","background:bisque;color:black;");
   document.getElementById("message2").setAttribute("style","background: bisque;color:black;");
    document.getElementById("username1").innerHTML = "Username:";
      document.getElementById("message1").innerHTML = "Message:";
        return false;
}  
 else  if(!message.match(ck_message))
{  alert("truen3");
    document.getElementById("message2").setAttribute("style","background: #ed5454;color:white;");
    document.getElementById("message1").innerHTML = "message should not be blank and 3-40 length";
     document.getElementById("username2").setAttribute("style","background:bisque;color:black;");
   document.getElementById("subject2").setAttribute("style","background: bisque;color:black;");
    document.getElementById("username1").innerHTML = "Username:";
      document.getElementById("subject1").innerHTML = "Message:";
        return false;
}

                
                
               
           }
 
      

        
    
    
            
        </script>
        
    </head>

    <body>
        <!--<div id="load_screen"><div id="loading"><center><img src="addingGif.gif"/></center></div></div>-->
        <div id="div_1" style="color: white;  height: 120px; width: 70px; background: red; float: left;">
            <h1 style="font-size:  72px;">E-MAILER</h1> 

            <h6>we do things that connect...</h6>
   
        </div>
        
        <div id="div_2" style="background-color:#01aed3; width: 370px;height:120px;" >
        </div>
        <br style="clear: both;"/>
        <div style=" padding-top: 50px;"><h1>WELCOME</h1>
            <h1><% HttpSession hs=request.getSession(false);
                String g=(String)hs.getAttribute("uniform");
                out.println(g);
                %>
</h1>        
         
        
        </div>
        <div style="width: 340px;height: 1500px; background: wheat;float: left; border-radius: 40px;">
            <div style="width: 340px;height: 200px; border-radius: 20px; background:  #01aed3; padding-top: 40px;overflow:  scroll; color: white; " > <h3> PEOPLE ONLINE...</h3></div>
            <a href="/mailernass/inbox">IN BOX</a>
            <br/>
            <a href="/mailernass/outbox">OUT BOX</a>
            <br/>
            <a href="/mailernass/login.jsp">COMPOSE</a>
             <br/>
            <a href="/mailernass/conduit">LOGOUT</a>   
            </div><!--compose mail division-->
                     
            
        
                <div style="width: 900px;height: 1500px; background: papayawhip ;float:right; border-left: dotted;  border:  #120a09 solid; border-radius: 20px;">
                    <h2 style="color: greenyellow;">MESSAGE SUCCESSFULLY SENT</h2>
                    <h3>YOU CAN COMPOSE MAIL TO ANY OF ABOVE MENTIONED USERS HERE</h3>
            <div style="width: 340px;height: 300px; background: wheat; border-radius: 40px;padding-left: 20px;">
                <form action="connectorBtwMessageSendAndDbse" onsubmit="return check();" method="post" >  <!-- remember to do a link-->
                <label id="username1">TO WHOM*mandatory</label>
                <br/>
                <input type="text" name="to" id="username2" style="background:#f5e5e5;"/>
                <br/>
                    <label id="subject1">SUBJECT*mandatory</label>
                <br/>
                <input type="text" name="subject" style="background:#f5e5e5;" id="subject2"/>
                <br/>
                
                <label id="message1">MESSAGE*mandatory</label>
                <br/>
                <textarea name="message" cols="30" rows="4" style=" overflow: scroll;" id="message2" style="background:#f5e5e5;"></textarea>
                <br/>
          
                
                <input type="submit" value="send"/>
                </form>        
                       
                    
                </div>  
    
                </div>
    </body>
</html>
