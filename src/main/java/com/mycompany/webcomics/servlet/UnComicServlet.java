/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.webcomics.servlet;

import com.mycompany.webcomics.model.dao.ComicDAO;
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

/**
 *
 * @author OUTLET
 */
@WebServlet(name = "UnComicServlet", urlPatterns = {"/UnComic"})
public class UnComicServlet extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        
         HttpSession session = request.getSession();
            
            User userSession = (User) session.getAttribute("user");
            
            request.setAttribute("user", userSession );
        
             ComicDAO comicDao = new ComicDAO();
             int idComic = Integer.parseInt(request.getParameter("idComic"));
             
             Comic comic =  comicDao.getComic(idComic);
            
                 
            
             request.setAttribute("comic", comic);
             
             
                 
                 
             RequestDispatcher dispatcher  = request.getRequestDispatcher("UnComic.jsp");
             dispatcher.forward(request, response);
    }
   

 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
  
        processRequest(request, response);
        
    }

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
