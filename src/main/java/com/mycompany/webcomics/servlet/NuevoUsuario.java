/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.webcomics.servlet;

import com.mycompany.webcomics.model.dao.UserDAO;
import com.mycompany.webcomics.model.entities.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author OUTLET
 */
@WebServlet(name = "NuevoUsuario", urlPatterns = {"/NuevoUsuario"})
public class NuevoUsuario extends HttpServlet {

 

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        
        
        
        
        
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("nuevoUsuario.jsp");
        
        dispatcher.forward(request, response);
                
         
        
    }

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
         UserDAO userDAO = new UserDAO();
        
        //obtengo parametros
        String username = request.getParameter("username");
        String pass = request.getParameter("pass");
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String email = request.getParameter("email");
        String descripcion = request.getParameter("descripcion");
        String foto = "foto.jsp";
        
        //seteo usuaro 
        User newUser = new User();
        newUser.setUserId(0);
        newUser.setUserName(username);
        newUser.setUserPass(pass);
        newUser.setUserNombre(nombre);
        newUser.setUserApellido(apellido);
        newUser.setUserEmail(email);
        newUser.setUserDescripcion(descripcion);
        newUser.setUserFoto(foto);
        
        
        userDAO.nuevoUser(newUser);
      
         RequestDispatcher dispatcher = request.getRequestDispatcher("index.html");
        
        dispatcher.forward(request, response);
        
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
