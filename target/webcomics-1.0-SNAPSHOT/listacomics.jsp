<%-- 
    Document   : listacomics
    Created on : 08/05/2020, 21:09:23
    Author     : OUTLET
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="com.mycompany.webcomics.model.entities.Comic"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%  ArrayList<Comic> listaComic = (ArrayList<Comic>) request.getAttribute("listaComics");%>
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
            
            <% for(Comic unComic: listaComic){ %>      
                <div class="col-md-4 post container">
                                           <div class="caja">
                                               <a href="UnComic?idComic=<%=unComic.getComicId()%>" class="thumbnail"> <img class="img-thumbnail miniatura" src=" <%= unComic.getComicFoto() %> " alt=""></a>
                                               
                                                   
                                                   <div class="caption">
                                           
                                                   <h2><a href="UnComic?idComic=<%=unComic.getComicId()%>" class="post-titulo"> <%= unComic.getComicTitulo() %> </a></h2>
                                                   <span ><a href="" class="text-right"> <%= unComic.getComicCategoria().getCatNombre() %></a></span>
                                                   <br>
                                                   <span class="post-fecha"><%=unComic.getComicFecha()%> </span> por <span class="post-autor"><a href="#"> <%= unComic.getComicAutor()%> </a></span>
                                                   <p class="post-reseña"> <%= unComic.getComicDescripcion() %>
                                                           </p>
                                                   
                                                    </div> 
                                                   
                                               </div> 
                                               </div>
                                                           <% } %>
           
             
 
 
         </div>
         
 
    </section>
            <%@include file="scripts.jsp" %> 
    </body>
</html>
