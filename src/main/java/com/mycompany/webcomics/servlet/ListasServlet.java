
package com.mycompany.webcomics.servlet;

import com.mycompany.webcomics.model.dao.ListasDAO;
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


@WebServlet(name = "Listas", urlPatterns = {"/Listas"})
public class ListasServlet extends HttpServlet {

   protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            
       
            HttpSession session = request.getSession();
            
            User userSession = (User) session.getAttribute("user");
            
            request.setAttribute("user", userSession );
            
            
        int userID = userSession.getUserId();
        ListasDAO listasDAO = new ListasDAO();
        ArrayList<Comic> listaFav = listasDAO.getListaFav(userID);
        ArrayList<Comic> listaLeidos = listasDAO.getListaLeidos(userID);
        ArrayList<Comic> listaPendientes = listasDAO.getListaPendientes(userID);
        
        request.setAttribute("listaFav", listaFav);
        request.setAttribute("listaLeidos", listaLeidos);
        request.setAttribute("listaPendientes", listaPendientes);
        
       
        
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("Listas.jsp");
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
        
        
                   
         HttpSession session = request.getSession();
            User userSession = (User) session.getAttribute("user");
            int idUser = userSession.getUserId();
            String lista = request.getParameter("lista");
            int idComic = Integer.parseInt(request.getParameter("idComic"));
            
         System.out.println("lista: " + lista + " user "+ idUser);   
         
         
         if(lista != null){

            ListasDAO listasDAO = new ListasDAO();
      
            if( "pendientes".equals(lista)){
                listasDAO.AgregarPendiente(idComic, idUser);
            } if("favoritos".equals(lista)){
                listasDAO.AgregarFav(idComic, idUser);
            } if("leidos".equals(lista)){
                listasDAO.AgregarLeido(idComic, idUser);
            }
             
        } 
        processRequest(request, response);
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
