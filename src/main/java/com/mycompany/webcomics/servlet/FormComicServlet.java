/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.webcomics.servlet;

import com.mycompany.webcomics.model.dao.ComicDAO;

import com.mycompany.webcomics.model.entities.Categoria;
import com.mycompany.webcomics.model.entities.Comic;
import com.mycompany.webcomics.model.entities.Estado;
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
@WebServlet(name = "FormComicServlet", urlPatterns = {"/nuevoComic"})
public class FormComicServlet extends HttpServlet {

    
     protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         
               HttpSession session = request.getSession();
            
            User userSession = (User) session.getAttribute("user");
            
            request.setAttribute("user", userSession );
        
       try{
           
         ComicDAO comicDAO = new ComicDAO();
        //obtengo parametros
        String titulo = request.getParameter("titulo");
        int categoria = Integer.parseInt(request.getParameter("categoria"));
        int estado = Integer.parseInt(request.getParameter("estado"));
        String descripcion = request.getParameter("descripcion"); 
        String fecha = request.getParameter("fecha");
        String autor = request.getParameter("autor");
 
        //creo Comic
        Comic nuevoComic = new Comic(); 
        
        nuevoComic.setComicId(1);
        nuevoComic.setComicTitulo(titulo);
        
        Categoria newCat = new Categoria();
        newCat.setCatID(categoria);
        newCat.setCatNombre("categoria");
        nuevoComic.setComicCategoria(newCat);
        
        Estado newEst = new Estado();
        newEst.setEstadoId(estado);
        newEst.setEstadoNombre("vacio");
        nuevoComic.setComicEstado(newEst);
        
        nuevoComic.setComicDescripcion(descripcion);
        nuevoComic.setComicFoto("https://hablandodecomics.files.wordpress.com/2012/01/portada-93-hulk.jpg?w=584");
        
        
        nuevoComic.setComicAutor("autor 1");
        
        
        
        nuevoComic.setComicUser(userSession);
        
        nuevoComic.setComicFecha(fecha);
        
        
        
        
        comicDAO.guardarComic(nuevoComic);     
        
        
       
        
        
        
       } catch(NumberFormatException nfe) {
	out.println("Los datos recibidos no son números enteros");
}
       
        RequestDispatcher dispatcher = request.getRequestDispatcher("nuevoComic.jsp");
        
        
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
