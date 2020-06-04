
package com.mycompany.webcomics.servlet;

import com.google.gson.Gson;
import com.mycompany.webcomics.model.dao.ListasDAO;
import com.mycompany.webcomics.model.entities.Comic;
import com.mycompany.webcomics.model.entities.User;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "PublicacionesServlet", urlPatterns = {"/Publicaciones"})
public class PublicacionesServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        HttpSession session = request.getSession();
            
            User userSession = (User) session.getAttribute("user");
            
            request.setAttribute("user", userSession );
        
        int userID = userSession.getUserId();
        
    
        
        RequestDispatcher dispatcher= request.getRequestDispatcher("Publicaciones.jsp");
        dispatcher.forward(request, response); 
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
       
    }

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
       processRequest(request, response);
      
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
