<%-- 
    Document   : PanelDeControl
    Created on : 07/05/2020, 00:06:39
    Author     : OUTLET
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% User user = (User) request.getAttribute("user");%>
<!DOCTYPE html>
<html>
    <%@include file="head.jsp" %>
    <body>
         <%@include file="header.jsp" %>
        <br>
 <h2 class="text-center">Panel de control</h2>
 <br>
<div class="accordion" id="accordionExample">
    <div class="card">
        <div class="card-header" id="eliminarComic">
            <h2 class="mb-0">
            <button class="btn btn-link" type="button" data-toggle="collapse" data-target="#collapseOne" aria-expanded="false" aria-controls="collapseOne">
                Eliminar Comic
            </button>
            </h2>
        </div>
    
        <div id="collapseOne" class="collapse" aria-labelledby="eliminarComic" data-parent="#accordionExample">
            <div class="card-body">
                <form>
                    <div class="form-group row">
                    <label for="idComic" class="col-2 col-form-label">ID Comic</label> 
                    <div class="col-10">
                        <input id="idComic" name="idComic" type="text" class="form-control">
                    </div>
                    </div> 
                    <div class="form-group row">
                    <div class="offset-2 col-10">
                        <button name="submit" type="submit" class="btn btn-danger btn-lg btn-block">Eliminar</button>
                    </div>
                    </div>
                </form>
            </div>
      </div>


     
    </div>


    <div class="card">
        <div class="card-header" id="eliminarUsuario">
          <h2 class="mb-0">
            <button class="btn btn-link" type="button" data-toggle="collapse" data-target="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
              Eliminar Usuario
            </button>
          </h2>
        </div>
    
        <div id="collapseTwo" class="collapse" aria-labelledby="eliminarUsuario" data-parent="#accordionExample">
          <div class="card-body">
              <form>
                  <div class="form-group row">
                    <label for="idUser" class="col-2 col-form-label">ID User</label> 
                    <div class="col-10">
                      <input id="idUser" name="idUser" type="text" class="form-control">
                    </div>
                  </div> 
                  <div class="form-group row">
                    <div class="offset-2 col-10">
                      <button name="submit" type="submit" class="btn btn-danger btn-lg btn-block">Eliminar</button>
                    </div>
                  </div>
                </form>
          </div>
        </div>
    </div>

        <div class="card">
            <div class="card-header" id="eliminarCategoria">
              <h2 class="mb-0">
                <button class="btn btn-link" type="button" data-toggle="collapse" data-target="#collapseThree" aria-expanded="false" aria-controls="collapseThree">
                  Eliminar Categoria
                </button>
              </h2>
            </div>
        
            <div id="collapseThree" class="collapse" aria-labelledby="eliminarCategoria" data-parent="#accordionExample">
              <div class="card-body">
                  <form>
                      <div class="form-group row">
                        <label for="idCategoria" class="col-2 col-form-label">ID Categoria</label> 
                        <div class="col-10">
                          <input id="idCategoria" name="idCategoria" type="text" class="form-control">
                        </div>
                      </div> 
                      <div class="form-group row">
                        <div class="offset-2 col-10">
                          <button name="submit" type="submit" class="btn btn-danger btn-lg btn-block">Eliminar</button>
                        </div>
                      </div>
                    </form>
              </div>
            </div>
        </div>
   <%@include file="scripts.jsp" %> 
    </body>
</html>
