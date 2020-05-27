<%-- 
    Document   : nuevoUsuario
    Created on : 04/05/2020, 22:09:10
    Author     : OUTLET
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="head.jsp" %>
    <body class="bg-dark">
   
        <div id="divcuadroform" class="container bg-light">
        <h2 class="text-center mt-2"> Registrar nuevo usuario</h2>
        <form action="" method="post">
            
                <div class="form-group">
                    <label for="username">Nombre de usuario</label>
                    <input class="form-control" type="text" name="username" placeholder="Nombre de usuaio">
                </div>
            
                <div class="form-group">
                    <label for="pass">Contraseña</label>
                    <input class="form-control" type="password" name="pass" placeholder="contraseña">
                </div>
            
                <div class="form-row">
                
                    <div class="form-group col-6">
                        <label for="nombre">Nombre</label>
                    <input class="form-control" type="text" name="nombre" placeholder="Nombre">
                    </div>
                    <div class="form-group col-6 ">
                        <label for="apellido">Apellido</label>
                    <input class="form-control" type="text" name="apellido" placeholder="Apellido">
                    </div>
    
                </div>
            
                <div class="form-group">
                    <label for="email">Email</label>
                    <input class="form-control" type="email" name="email" placeholder="email">
                </div>
                
                <div class="form-group">
                 <label for="descripcion">Sinopsis </label>
                 <textarea class="form-control" name="descripcion" id="descripcion" placeholder="Esta descripcion aparecera publicada en tu perfil"></textarea>

                 </div>
                
                <div class="form-group">
                    <label for="foto"> Foto</label>
                    <input type="file" name="foto" id="foto">
                </div>
            
                <div class="form-group">
                       <div class="form-check">
                              <input class="form-check-input" type="checkbox" value="" id="invalidCheck" required>
                              <label class="form-check-label" for="invalidCheck">Terminos y condiciones</label>
                              <div class="invalid-feedback">
                                  Debe aceptar terminos y condiciones
                              </div>
                        </div>
                </div>
            
                
                <button class="btn btn-dark" type="submit">Registrar</button>

            
        </form>
    </div>
        
        
    <%@include file="scripts.jsp" %>  
    </body>
</html>
