<%-- 
    Document   : Perfil
    Created on : 05/05/2020, 18:33:44
    Author     : OUTLET
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="com.mycompany.webcomics.model.entities.Comic"%>
<%@page import="com.mycompany.webcomics.model.entities.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% User user = (User) request.getAttribute("user");%>
<% ArrayList<Comic> listaFav = (ArrayList<Comic>) request.getAttribute("listaFav"); %>
<% ArrayList<Comic> listaLeidos = (ArrayList<Comic>) request.getAttribute("listaLeidos"); %>
<% ArrayList<Comic> listaPendientes = (ArrayList<Comic>) request.getAttribute("listaPendientes"); %>
<% ArrayList<Comic> publicUser = (ArrayList<Comic>) request.getAttribute("publicUser"); %>
<!DOCTYPE html>
<html>
    <%@include file="head.jsp" %>
    
    <body>
        <%@include file="header.jsp" %>
        <div class="container" id="fondo">

     <!--foto de perfil y presentacion-->

    <div class="row">
        <section class="col col-sm-12 col-md-3" id="asidePerfil">
            <img id="fotoPerfil" class="img-thumbnail" src="<%= user.getUserFoto()%>" alt="">
            <br>
            <ul class="list-group">
                <li><%= user.getUserNombre()%>  <%= user.getUserApellido() %></li>
                <li><%= user.getUserEmail() %> </li>
            </ul>

        </section>
        <section id="cajaperfil" class="col col-sm-12 col-md-9">
            
            
            <h2 id="nombreDeUsuario" ><%= user.getUserName()%></h2> 
            <br>
            <p id="presentacionPerfil"> <%= user.getUserDescripcion() %>
            </p>
            
            
            

        </section>
     </div>
</div>

<!--publicaciones-->
<div class="container">
    <h2 class="text-center">Publicaciones</h2>
    
        <table id="lista-publicaciones" class="table table-striped">
            
            <tbody>
                 
                <% for(Comic unComic: publicUser){ %>
                
                <tr>
                    <td><img class="img-thumbnail icono-lista-comic" src="<%= unComic.getComicFoto()%> " alt=""> <a href="UnComic?idComic=<%=unComic.getComicId()%>"> <%= unComic.getComicTitulo()%> </a> <button type="button" class="close" aria-label="Close">
                      </button</td>
                </tr>
                <% } %>
            </tbody>
        </table>


</div>

<!--listas-->

<h3 class="text-center">Listas</h3>

<div class="container">
    <ul class="nav nav-tabs" id="myTab" role="tablist">
        <li class="nav-item">
          <a class="nav-link active" id="leidos-tab" data-toggle="tab" href="#leidos" role="tab" aria-controls="leidos" aria-selected="true">Leidos</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" id="favoritos-tab" data-toggle="tab" href="#favoritos" role="tab" aria-controls="favoritos" aria-selected="false">Favoritos</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" id="pendientes-tab" data-toggle="tab" href="#pendientes" role="tab" aria-controls="pendientes" aria-selected="false">Pendientes</a>
        </li>
      </ul>
      <div class="tab-content" id="myTabContent">
        <div class="tab-pane fade show active" id="leidos" role="tabpanel" aria-labelledby="leidos-tab">
            <table id="lista-leidos" class="table table-striped">
            
                <tbody>
                     <% for (Comic unComic: listaLeidos){ %>
                    
                    <tr>
                        <td><img class="img-thumbnail icono-lista-comic" src=" <%= unComic.getComicFoto()%> " alt=""> <a href="UnComic?idComic=<%=unComic.getComicId()%>"> <%= unComic.getComicTitulo()%></a> <button type="button" class="close" aria-label="Close">
                          </button</td>
                    </tr>
                    
                    <% } %>
                  
                </tbody>
            </table>
        </div>
        <div class="tab-pane fade" id="favoritos" role="tabpanel" aria-labelledby="favoritos-tab">
            <table id="lista-favoritos" class="table table-striped">
            
                <tbody>
                    <tbody>
                     <% for (Comic unComic: listaFav){ %>
                    
                    <tr>
                        <td><img class="img-thumbnail icono-lista-comic" src=" <%= unComic.getComicFoto()%> " alt=""> <a href="UnComic?idComic=<%=unComic.getComicId()%>"> <%= unComic.getComicTitulo()%></a> <button type="button" class="close" aria-label="Close">
                          </button</td>
                    </tr>
                    
                    <% } %>
                </tbody>
            </table>
        </div>
        <div class="tab-pane fade" id="pendientes" role="tabpanel" aria-labelledby="pendientes-tab"> <table id="lista-publicaciones" class="table table-striped">
            
            <tbody>
                <tr>
                    <tbody>
                     <% for (Comic unComic: listaPendientes){ %>
                    
                    <tr>
                        <td><img class="img-thumbnail icono-lista-comic" src=" <%= unComic.getComicFoto()%> " alt=""> <a href="UnComic?idComic=<%=unComic.getComicId()%>"> <%= unComic.getComicTitulo()%></a> <button type="button" class="close" aria-label="Close">
                          </button</td>
                    </tr>
                    
                    <% } %>
                </tr>
                
            </tbody>
        </table>
    </div>
      </div>
</div>
        
        
        
        <%@include file="scripts.jsp" %>
    </body>
</html>
