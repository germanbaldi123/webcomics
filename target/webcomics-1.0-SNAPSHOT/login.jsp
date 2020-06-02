<%-- 
    Document   : login
    Created on : 08/05/2020, 21:45:56
    Author     : OUTLET
--%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.mycompany.webcomics.model.entities.Comic"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%  ArrayList<Comic> listaComic = (ArrayList<Comic>) request.getAttribute("listaComics");%>
<!DOCTYPE html>
<html>
       <%@include file="head.jsp" %> 
     
  <body>


<div class="container-block">
                      <nav class="navbar navbar-expand-lg navbar-dark bg-dark sticky-top">
                                <a href="index.html" class="navbar-brand">La Guarida</a>
                                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#menu" aria-controls="menu">
                                        <span class="navbar-toggler-icon"></span>
                                </button>


                                <div class="navbar-collapse collapse" id="menu">

                                        <form class="form-inline my-8 col-lg-10">
                                            <input class="form-control col-sm-6" type="search" placeholder="Search" aria-label="Search">
                                            <button class="btn btn-outline-light my-2 my-sm-0" type="submit">Search</button>
                                        </form>
                                        <ul class="navbar-nav mr-auto my-2 my-lg-0">
                                                <li class="navbar-item  mr-sm-2">
                                                    <a href="#" class="nav-link " id="biblioteca" role="button" data-toggle="modal" data-target="#exampleModal" >Iniciar Sesion</a>
                                                </li>
                                                <li class="navbar-item  mr-sm-2">
                                                        <a href="NuevoUsuario" class="nav-link " id="miCuenta" ">Registrarse</a>
                                                </li>




                                        </ul>



                                </div>



                        </nav>
                    </div>
      
<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Iniciar Sesion</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <form action="index.html" method="post">
            <div class="form-group">              
            <label for="username">Nombre de usuario</label>
            <input class="form-control" id="username" name="username" type="text">
            </div>
            <div class="form-group">  
            <label for="pass">Contraseña</label>
            <input class="form-control" id="pass" name="pass" type="password">
            </div>
            <input type="submit" value="Iniciar sesion" class="btn btn-dark"/> <a class="btn btn-dark" href="NuevoUsuario">Registrarse</a>
        </form>
      </div>
    </div>
  </div>
</div>  
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
                                               <a href="#" class="thumbnail" role="button" data-toggle="modal" data-target="#exampleModal"> <img class="img-thumbnail miniatura" src=" <%= unComic.getComicFoto() %> " alt=""></a>
                                               
                                                   
                                                   <div class="caption">
                                           
                                                   <h2><a class="post-titulo"> <%= unComic.getComicTitulo() %> </a></h2>
                                                   <span ><a class="text-right"> <%= unComic.getComicCategoria().getCatNombre() %></a></span>
                                                   <br>
                                                   <span class="post-fecha"><%=unComic.getComicFecha()%> </span> por <span class="post-autor"><a> <%= unComic.getComicAutor() %> </a></span>
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
