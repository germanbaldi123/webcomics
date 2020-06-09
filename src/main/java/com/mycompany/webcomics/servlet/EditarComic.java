/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.webcomics.servlet;

import com.mycompany.webcomics.model.dao.ComicDAO;
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
@WebServlet(name = "EditarComic", urlPatterns = {"/EditarComic"})
public class EditarComic extends HttpServlet {

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
     RequestDispatcher dispatcher = request.getRequestDispatcher("/EditarComic.jsp"); 
     
     HttpSession session = request.getSession();
     User user = (User) request.getAttribute("user");
    
     
     int idComic = Integer.parseInt(request.getParameter("idComic"));
     
     ComicDAO comicDAO = new ComicDAO();
     Comic comic = comicDAO.getComic(idComic);
     
     request.setAttribute("comic", comic);
     request.setAttribute("user", user); 
     
     

   
         


     
     
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
    
            String titulo = request.getParameter("titulo");
         String autor = request.getParameter("autor");
         String descripcion = request.getParameter("descripcion");
         String fecha = request.getParameter("fecha");
         int id = Integer.parseInt(request.getParameter("id")); 
         int est = Integer.parseInt(request.getParameter("estado")); 
         
         Comic comicEditado = new Comic();
         
         comicEditado.setComicId(id);
         comicEditado.setComicAutor(autor);
         comicEditado.setComicTitulo(titulo);
         comicEditado.setComicDescripcion(descripcion);
         comicEditado.setComicFecha(fecha);
         
         Estado estado = new Estado();
         estado.setEstadoId(est);
         estado.setEstadoNombre("vacio");
         
         comicEditado.setComicEstado(estado);
         
         ComicDAO editarDAO = new ComicDAO();
         editarDAO.editarComic(comicEditado);

        
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
