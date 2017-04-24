<%-- 
    Document   : redirectedLogin
    Created on : Apr 2, 2017, 2:00:05 PM
    Author     : laura
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Login</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width">
        <link rel="stylesheet" type="text/css" href="./css/style.css">     
    </head>
    
    <body>
        <div id="whole">
            
            <div class="row">
            
            	<div class="col-2">
	</div>
            <div class="col-8">
            <nav class="menu">
                <ul>
                    <li>
                    <a href="index.jsp">Home</a>
                    </li>
                    <li>
                    <a href="Login">Login</a>
                    </li>
                    <li>
                    <a href="./RegistrationView.html">Register</a>   
                    </li>
                    <li>
                    <a href="/">New Additions</a>
                    </li>
                    <li>
                    <a href="/">Movie Trailers</a>
                    </li>
                    <li>
                    <a href="/">Book Tickets</a>
                    </li>
                     <li>
                    <a href="/">About Us</a>
                    </li>
                    <li>
                    <a href="/">Log Out</a>
                    </li>
                </ul>
            </nav>
            </div>
                            	<div class="col-2">
	</div>
                </div>            
	<div class="col-2">
	</div>
	<div id="stuff" class="col-8">
        <div class="row">
                             <%
                  if(request.getAttribute("error")!=null) {      %>
                 <p id="error">(<%= request.getAttribute("error") %>) </p>
<% } %>
                 <div id="myNiceForm" class="col-12">
            <h1>Login form</h1>   
            <form method="POST" action="loginController">
                
                <div class="form-element">
                    <label for="username">Username</label>
                    <input type="text" name="uname" id="uname">
                </div>
                <div class="form-element">
                    <label for="password">Password</label>
                    <input type="password" name="password" id="password">
                </div>
                
                <div class="form-element">
                    <input type="submit" value="Submit">
                    <input type="reset" value="Reset">
                </div>  

                      
                    
            </form>
            </div>
            </div>
        </div>
        <div class="col-2">
	</div>
        </div>
    </body>
</html>
