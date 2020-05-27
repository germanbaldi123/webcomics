<%-- 
    Document   : UnComic
    Created on : 05/05/2020, 19:48:20
    Author     : OUTLET
--%>

<%@page import="com.mycompany.webcomics.model.entities.Comic"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% User user = (User) request.getAttribute("user");%>
<% Comic comic = (Comic) request.getAttribute("comic");%>
<!DOCTYPE html>
<html>
    <%@include file="head.jsp" %>
    <body>
    <%@include file="header.jsp" %>
       <div class="container">
          <section class="main row">
              <article class="col col-sm-3">
                  <img src=" <%= comic.getComicFoto() %>  " class="img-thumbnail " alt="">

              </article>
              <article class="col col-sm-9">
                    <h1 class="text-center"> <%=comic.getComicTitulo()%>  </h1>
                    <h5 class="text-center"><%=comic.getComicFecha()%>  por <a href=""> <%=comic.getComicAutor() %> </a> <a class="text-secondary" href="">- <%=comic.getComicCategoria().getCatNombre() %> </a></h5>
                     <p><%=comic.getComicDescripcion()%> 
                     </p>
                 
                      <!--botones leer y agregar a lista-->
                    
                      <div class="row" id="botonera">
                        <button class="btn btn-primary col-xs-9 col-md-6 my-1" data-toggle="modal" data-target="#exampleModal">Leer</button>
                        <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                            <div class="modal-dialog" role="document">
                              <div class="modal-content">
                                <div class="modal-header">
                                  <h5 class="modal-title" id="exampleModalLabel"><%=comic.getComicTitulo()%> - Capitulo 1</h5>
                                  <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                  </button>
                                </div>
                                <div class="modal-body">
                                    <div id="carouselExampleInterval" class="carousel slide" data-ride="carousel">
                                        <div class="carousel-inner">
                                          <div class="carousel-item active" data-interval="10000">
                                            <img src="img/tapaShamanKing.jpg" class="d-block w-100" alt="...">
                                          </div>
                                          <div class="carousel-item" data-interval="2000">
                                            <img src="img/SKcap1hoja1.jpg" class="d-block w-100" alt="...">
                                          </div>
                                          <div class="carousel-item">
                                            <img src="img/SKcap1hoja2.jpg" class="d-block w-100" alt="...">
                                          </div>
                                        </div>
                                        <a class="carousel-control-prev" href="#carouselExampleInterval" role="button" data-slide="prev">
                                          <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                                          <span class="sr-only">Previous</span>
                                        </a>
                                        <a class="carousel-control-next" href="#carouselExampleInterval" role="button" data-slide="next">
                                          <span class="carousel-control-next-icon" aria-hidden="true"></span>
                                          <span class="sr-only">Next</span>
                                        </a>
                                      </div>
                                </div>
                                
                              </div>
                            </div>
                          </div>

                     
                       <div class="dropdown col-xs-6 col-md-6 my-1">
                            <button class="btn btn-success dropdown-toggle" type="button" id="agregarLista" data-toggle="dropdown" aria-extended="true">+Agregar a lista</button>
                            <div class="dropdown-menu" role="menu" aria-labelledby="#agregarLista">
                                <a id="btnPendientes" class="dropdown-item" href="#">Pendientes</a>
                                <a id="btnFav" class="dropdown-item"  href="#">Favoritos</a>
                                <a id="btnLeidos"  class="dropdown-item"  href="#">Leidos</a>
                                
                                
                            </div>
                        </div>
                    </div>
                     

                </article>         
                        
                      
                         
                        
                         
                        

             </section>
          

        </div>
        
        <div class="container">
            <br>
        <ol class="list-group ">
            <li class="list-group-item"><a href="#">Capitulo 1</a></li>
            <li class="list-group-item"><a href="#">Capitulo 2</a></li>
            <li class="list-group-item"><a href="#">Capitulo 3</a></li>
            <li class="list-group-item"><a href="#">Capitulo 4</a></li>
            <li class="list-group-item"><a href="#">Capitulo 5</a></li>
            
        </ol>
        </div>
    
    
     <script src="js/agregarLista.js"></script>
    <%@include file="scripts.jsp" %>      
    </body>
</html>
