<%-- 
    Document   : Listas
    Created on : 05/05/2020, 16:28:35
    Author     : OUTLET
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="com.mycompany.webcomics.model.entities.Comic"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% User user = (User) request.getAttribute("user");%>
<% ArrayList<Comic> listaFav = (ArrayList<Comic>) request.getAttribute("listaFav"); %>
<% ArrayList<Comic> listaLeidos = (ArrayList<Comic>) request.getAttribute("listaLeidos"); %>
<% ArrayList<Comic> listaPendientes = (ArrayList<Comic>) request.getAttribute("listaPendientes"); %>
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


        <table id="lista-leidos" class="table table-striped">
            <thead >
                <th class="table-success" scope="col"> Leidos</th>
            </thead>
            <tbody>
             
                <%for(Comic unComic: listaLeidos){ %>
                <tr>
                    <td><img class="img-thumbnail icono-lista-comic" src=" <%= unComic.getComicFoto()%>  " alt=""> <a href="UnComic?idComic=<%=unComic.getComicId()%>"> <%= unComic.getComicTitulo() %> </a>
                        <button type="button" class="close eliminarLeido" value="<%=unComic.getComicId()%>" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                        </button></td>
                </tr>
                
                <% } %>
               
                
            </tbody>
        </table>


        <br>


        <table id="lista-favoritos" class="table table-striped">
            <thead >
                <th class="table-warning" scope="col"> Favoritos</th>
            </thead>
            <tbody>
                
               
              <%for(Comic unComic: listaFav){ %>
                <tr>
                    <td><img class="img-thumbnail icono-lista-comic" src=" <%= unComic.getComicFoto()%>  " alt=""> <a href="UnComic?idComic=<%=unComic.getComicId()%>"> <%= unComic.getComicTitulo() %> </a>
                        <button type="button" class="close eliminarFav" value="<%=unComic.getComicId()%>" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                        </button></td>
                </tr>
                
                <% } %>
            </tbody>
        </table>


       


        <br>


        <table id="lista-pendientes" class="table table-striped">
            <thead >
                <th class="table-secondary" scope="col"> Pendientes</th>
            </thead>
            <tbody>
                
               <%for(Comic unComic: listaPendientes){ %>
                <tr>
                    <td><img class="img-thumbnail icono-lista-comic" src=" <%= unComic.getComicFoto()%>  " alt=""> <a href="UnComic?idComic=<%=unComic.getComicId()%>"> <%= unComic.getComicTitulo() %> </a>
                        <button type="button" class="close eliminarPendiente" value="<%=unComic.getComicId()%>" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                        </button></td>
                </tr>
                
                <% } %>
            </tbody>
        </table>


    
      
    </div>

            <script src="js/eliminarListas.js"></script>
        <%@include file="scripts.jsp" %>
    </body>
</html>
