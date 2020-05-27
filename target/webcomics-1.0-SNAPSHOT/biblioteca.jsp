

<%@page import="java.util.ArrayList"%>
<%@page import="com.mycompany.webcomics.model.entities.User"%>
<%@page import="com.mycompany.webcomics.model.entities.Comic"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!-- <%  ArrayList<Comic> listaComic = (ArrayList<Comic>) request.getAttribute("listaComicsCat");%>
<% User user = (User) request.getAttribute("user");%> -->
<!DOCTYPE html>
<html>
    <%@include file="head.jsp" %> 
     
    <body>
    <%@include file="header.jsp" %>
       <br>
    

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
