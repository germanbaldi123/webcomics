

<%@page import="com.mycompany.webcomics.model.entities.Comic"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% Comic comic = (Comic) request.getAttribute("comic"); %>
<% User user = (User) request.getAttribute("user");%>
<!DOCTYPE html>
<html>
<%@include file="head.jsp" %>
    <body>
        <%@include file="headerdos.jsp" %>
        <br>
        <h3 class="text-center">Editar Comic</h3>
        
        <div class="container">
             <form method="post" >
                 <div class="col-8">
        <input  id="id" name="id" type="hidden" class="form-control" value="<%=comic.getComicId()%>" >
    </div>
  <div class="form-group row">
    <label for="titulo" class="col-4 col-form-label">Titulo</label> 
    <div class="col-8">
        <input id="titulo" name="titulo" type="text" class="form-control" value=" <%=comic.getComicTitulo()%> ">
    </div>
  </div>
  <div class="form-group row">
    <label for="autor" class="col-4 col-form-label">Autor</label> 
    <div class="col-8">
        <input id="autor" name="autor" type="text" class="form-control" value="<%=comic.getComicAutor()%>">
    </div>
  </div>
  <div class="form-group row">
    <label for="fecha" class="col-4 col-form-label">Año de publicacion</label> 
    <div class="col-8">
      <input id="fecha" name="fecha"  type="text" class="form-control" value="<%=comic.getComicFecha()%>">
    </div>
  </div>
 <div class="form-group row">
    <label for="descripcion" class="col-4 col-form-label">Descripcion</label> 
    <div class="col-8">
      <textarea id="descripcion" name="descripcion" cols="40" rows="5" class="form-control"><%=comic.getComicDescripcion()%></textarea>
    </div>
  </div> 
      <div class="form-group row">
    <label for="estado" class="col-4 col-form-label">Estado</label> 
    <div class="col-8">
      <select id="estado" name="estado" class="custom-select">
        <option value="1">En Curso</option>
        <option value="2">Finalizado</option>
      </select>
    </div>
  </div>
    
<div class="offset-4 col-8">
    <button name="submit" id="submit" type="submit" class="btn btn-success">Editar</button>
    </div>      
       

</form>
      
     </div>
        
        
      <!-- <script src="js/editarPublicacion.js" ></script> -->
        <%@include file="scripts.jsp" %>
    </body>
</html>
