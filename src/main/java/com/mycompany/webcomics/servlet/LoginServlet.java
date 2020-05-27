/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.webcomics.servlet;

import com.mycompany.webcomics.model.dao.ComicDAO;
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

/**
 *
 * @author OUTLET
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/index.html"})
public class LoginServlet extends HttpServlet {



    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
       
        
        if ( session.getAttribute("user") != null ){
            request.getRequestDispatcher("/comic").forward(request, response);
            
        }else{
            RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
            ComicDAO comicDao = new ComicDAO();
            ArrayList<Comic> listaComics =  comicDao.getListadoComic();
            request.setAttribute("listaComics", listaComics);
            dispatcher.forward(request, response);
        }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
     String username = request.getParameter("username");
     String pass = request.getParameter("pass");

     
     UserDAO userDAO = new UserDAO();
     User user = userDAO.getUserLogin(username);
     
     HttpSession session = request.getSession();
     
     if( pass.equals(user.getUserPass())){
         
       
         
         RequestDispatcher dispatcher = request.getRequestDispatcher("/comic");
         
           session.setAttribute("user", user);
         
         
         dispatcher.forward(request, response);
         
       
     }else {
          RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
            ComicDAO comicDao = new ComicDAO();
            ArrayList<Comic> listaComics =  comicDao.getListadoComic();
            request.setAttribute("listaComics", listaComics);
            dispatcher.forward(request, response);
     }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
