<%-- 
    Document   : nuevoComic
    Created on : 04/05/2020, 13:22:20
    Author     : OUTLET
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% User user = (User) request.getAttribute("user");%>
<!DOCTYPE html>
<html>
     <%@include file="head.jsp" %>
    
    <body>
    <%@include file="header.jsp" %>
     <div class="container">
         <br>
         <form action="">
             <div class="form-group">
                 <label for="titulo"><strong> Titulo </strong></label>
                 <input class="form-control" type="text" name="titulo" id="titulo" placeholder="Titulo de la publicacion">
             </div>
             <div class="form-group">
                <label for="autor"><strong> Autor</strong></label>
                <input class="form-control" type="text" name="autor" id="autor" placeholder="Nombre de autor">
            </div>
             <div class="form-group">
                 <label for="genero"><strong>Seleccionar Genero</strong> </label>
                <select id="categoria" name="categoria" class="custom-select" aria-describedby="categoriaHelpBlock">
                    <option value="1">Accion</option>
                    <option value="3">Romance</option>
                    <option value="4">Terror/Misterio</option>
                    <option value="5">Deporte</option>
                    <option value="6">infantil</option>
                    <option value="2">comedia</option>
                  </select> 
             </div>
             <div class="form-group">
                 <label for="estado"><strong>Estado</strong> </label>
                <select id="estado" name="estado" class="custom-select" aria-describedby="categoriaHelpBlock">
                    <option value="1">En curso</option>
                    <option value="2">Finalizado</option>
                  </select> 
             </div>
             <div class="form-group">
                <label for="fecha"><strong> Año de publicacion</strong></label>
                <input class="form-control" type="text" name="fecha" id="autor" placeholder="Año de publicacion">
            </div>
             <div class="form-group">
                 <label for="descripcion"><strong>Sinopsis</strong> </label>
                 <textarea class="form-control" name="descripcion" id="descripcion" placeholder="Breve reseña de la historia"></textarea>

             </div>

             <div class="form-group">
                 <label for="tapa"><strong>Tapa</strong> </label> <br>
                 <input type="file" name="tapa" id="tapa">
             </div>

             <div class="form-group">
                 <label><strong>Priemr Capitulo</strong> </label>
                 <br>
                 <label for="paginaUno">Pagina 1</label>
                 <input type="file" name="paginaUno" id="paginaUno">
                 <br>
                 <label for="paginaDos">Pagina 2</label>
                 <input type="file" name="paginDoso" id="paginaDos">
                 <br>
                 <label for="paginaTres">Pagina 3</label>
                 <input type="file" name="paginaTres" id="paginaTres">
                 <br>
                <button class="btn btn-secondary">+</button>
             </div>
             <div class="form-group">
                 <button class="btn btn-primary btn-lg btn-block" type="submit">Enviar</button>
             </div>
         </form>
     </div>
        
        <%@include file="scripts.jsp" %>  
    </body>
</html>
