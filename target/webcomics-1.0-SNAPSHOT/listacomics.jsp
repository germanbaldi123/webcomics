<%-- 
    Document   : listacomics
    Created on : 08/05/2020, 21:09:23
    Author     : OUTLET
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="com.mycompany.webcomics.model.entities.Comic"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<% User user = (User) request.getAttribute("user");%>
<!DOCTYPE html>
<html>
     <%@include file="head.jsp" %> 
     
    <body>
    <%@include file="header.jsp" %>
       <br>
    
    <section class="jumbotron">
        <div class="container">
            <h1>La Guarida del Caballero</h1>
            <p>Libreria de comics</p>
        </div>
    </section>


    <section class="container main">
        <div class="row" id="cajaPubli">
            
           
             
 
 
         </div>
         
 
    </section>
            <script src="js/index.js"></script>
            <%@include file="scripts.jsp" %> 
    </body>
</html>
