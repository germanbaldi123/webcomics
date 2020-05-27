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
        <div class="row">
            <div class="col-md-4 post container">
                <div class="caja">
                   
                   <a href="nuevoComic"> <h5 id="mas" class="text-center">+</h5>
                    <h3 id="nuevaPublicacion" class="text-center">Nueva Publicacion</h3></a>
                </div>
                
 
            </div>
            
            <% for(Comic unComic: publicUser){ %>
            <div class="col-md-4 post container">
               <div class="caja">
                   <a href="#" class="thumbnail"> <img class="img-thumbnail miniatura" src=" <%= unComic.getComicFoto()%>" alt=""></a>
                  <div class="caption">
 
                  <h2><a href="#" class="post-titulo"><%= unComic.getComicTitulo()%></a></h2>
                  <span class="post-fecha">1998</span> por <span class="post-autor"><a href="#"><%= unComic.getComicAutor() %></a></span>
                  <p class="post-reseña"> <%= unComic.getComicDescripcion()%></p>
                  <div class="contenedor-de-botones row container">
                     <a href="EditarComic?idComic=<%=unComic.getComicId()%>"><button class="btn col btn-success editarComic"  value="<%=unComic.getComicId()%>"> Editar </button></a>

                      <div class="col">
                          <button class="btn btn-danger col eliminarComic" value="<%=unComic.getComicId()%>">Eliminar</button>
                       </div>

                  
                    
                     
                     
 
                  
 
                   </div>   
               </div>
            
             </div>
 
         </div>
                   <% } %>
 
         
        </div>


 
    </section>

   <script src="js/eliminarPublicacion.js"></script>
    <%@include file="scripts.jsp" %>
    </body>
</html>
