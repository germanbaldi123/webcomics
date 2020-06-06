<%-- 
    Document   : Listas
    Created on : 05/05/2020, 16:28:35
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
        <%@include file="headerdos.jsp" %>
        <div class="container-fluid">
        <nav class="navbar">
            <ul class="btn-group btn-group" role="group">
                
               
                  <a href="#lista-leidos" ><button class="btn btn-success btn-group" type="button">Leidos</button></a>
                
                
                    <a href="#lista-favoritos" ><button class="btn btn-warning btn-group" type="button">Favoritos</button></a>
               
                    <a href="#lista-pendientes" ><button class="btn btn-secondary btn-group" type="button">Pendientes</button></a>
               
               
            </ul>
        </nav>

        
         <!--listas-->   
       


        <br>


        <table  class="table table-striped">
            <thead >
                <th class="table-success" scope="col"> Leidos</th>
            </thead>
            <tbody id="lista-leidos">
             
              
                
            </tbody>
        </table>


        <br>


        <table  class="table table-striped">
            <thead >
                <th class="table-warning" scope="col"> Favoritos</th>
            </thead>
            <tbody id="lista-favoritos">
                
               
             
            </tbody>
        </table>


       


        <br>


        <table  class="table table-striped">
            <thead >
                <th class="table-secondary" scope="col"> Pendientes</th>
            </thead>
            <tbody id="lista-pendientes" >
                
               
            </tbody>
        </table>


    
      
    </div>

            <script src="js/listas.js"></script>
        <%@include file="scripts.jsp" %>
    </body>
</html>
