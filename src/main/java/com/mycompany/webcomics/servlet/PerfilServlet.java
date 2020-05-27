
package com.mycompany.webcomics.servlet;

import com.mycompany.webcomics.model.dao.ListasDAO;
import com.mycompany.webcomics.model.dao.UserDAO;
import com.mycompany.webcomics.model.entities.Comic;
import com.mycompany.webcomics.model.entities.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "PerfilServlet", urlPatterns = {"/Perfil"})
public class PerfilServlet extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        HttpSession session = request.getSession();
            
            User userSession = (User) session.getAttribute("user");
            
            request.setAttribute("user", userSession );
        
        
        UserDAO userDAO = new UserDAO();
        int userID = userSession.getUserId(); 
        User user = userDAO.getUser(userID);
        
        ListasDAO listasDAO = new ListasDAO();
        ArrayList<Comic> listaFav = listasDAO.getListaFav(userID);
        ArrayList<Comic> listaLeidos = listasDAO.getListaLeidos(userID);
        ArrayList<Comic> listaPendientes = listasDAO.getListaPendientes(userID);
        ArrayList<Comic> publicUser = listasDAO.getPublicUser(userID);
        
        request.setAttribute("listaFav", listaFav);
        request.setAttribute("listaLeidos", listaLeidos);
        request.setAttribute("listaPendientes", listaPendientes);
        request.setAttribute("publicUser", publicUser);
        
        request.setAttribute("user", user);
        
        RequestDispatcher dispatcher= request.getRequestDispatcher("Perfil.jsp");
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
    }

}
