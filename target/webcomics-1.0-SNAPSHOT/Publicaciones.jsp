<%-- 
    Document   : Publicaciones
    Created on : 05/05/2020, 19:16:56
    Author     : OUTLET
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="com.mycompany.webcomics.model.entities.Comic"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% User user = (User) request.getAttribute("user");%>
<% ArrayList<Comic> publicUser = (ArrayList<Comic>) request.getAttribute("publicUser"); %>
<!DOCTYPE html>
<html>
    <%@include file="head.jsp" %>
    <body>
    <%@include file="header.jsp" %>
    <br>
    
    <h2 class="text-center">Tus Publicaciones</h2>
    <br>
    
     <section class="container main">
        <div class="row" id="contenedor">
            
            
       
 
         
        </div>


 
    </section>
    
    <script src="js/mostrarPubicaciones.js"></script>
  <!-- <script src="js/eliminarPublicacion.js"></script> -->
   
    <%@include file="scripts.jsp" %>
    </body>
</html>
