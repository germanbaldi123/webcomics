/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.webcomics.servlet;

import com.mycompany.webcomics.model.dao.ListasDAO;
import com.mycompany.webcomics.model.dao.UserDAO;
import com.mycompany.webcomics.model.entities.User;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author OUTLET
 */
@WebServlet(name = "EliminarLista", urlPatterns = {"/EliminarLista"})
public class EliminarLista extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
       
        
           HttpSession session = request.getSession();

             User user = (User) session.getAttribute("user");

         request.setAttribute("user", user );
       
       try{
         ListasDAO listasDAO = new ListasDAO();
         int idUser = user.getUserId();
         int idComic = Integer.parseInt(request.getParameter("idComic"));
         String lista = request.getParameter("lista");
         
         if(lista != null){
             if ("favoritos".equals(lista)){
                 listasDAO.eliminarComicFav(idComic, idUser);               
             } if("leidos".equals(lista)){
                 listasDAO.eliminarComicLeidos(idComic, idUser);
             } if("pendientes".equals(lista)){
                 listasDAO.eliminarComicPendientes(idComic, idUser);
             }
         }
         
         } catch(NumberFormatException nfe) {
         out.println("Los datos recibidos no son números enteros");
         }
       
       RequestDispatcher dispatcher = request.getRequestDispatcher("eliminarLista.jsp");
       dispatcher.forward(request, response);
    }
    

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
