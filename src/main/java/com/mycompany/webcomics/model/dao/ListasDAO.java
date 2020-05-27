/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.webcomics.model.dao;

import com.mycompany.webcomics.model.entities.Categoria;
import com.mycompany.webcomics.model.entities.Comic;
import com.mycompany.webcomics.model.entities.Estado;
import com.mycompany.webcomics.model.entities.User;
import com.mycompany.webcomics.utils.ConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author OUTLET
 */
public class ListasDAO {
    
    public ArrayList<Comic> getListaFav(int userID){
        
        ArrayList<Comic> listaFav = new ArrayList<>();
        
        try {
             
            ConnectionManager connectionManager = new ConnectionManager();
            Connection con = connectionManager.getConnection();
            Statement stm;
            ResultSet rs;
            String sql;

            sql = "SELECT * FROM lista_fav, comic WHERE lista_fav.user_id_fav = " + userID + " AND lista_fav.comic_id_fav = comic.com_id";

            stm = con.createStatement();
            rs = stm.executeQuery(sql);

            while (rs.next()) {
                Comic comic = new Comic();

                comic.setComicTitulo(rs.getString("com_titulo"));

                Categoria categoria = new Categoria();
                categoria.setCatID(rs.getInt("com_cat_id"));
                categoria.setCatNombre("vacio");
                comic.setComicCategoria(categoria);

               
                comic.setComicAutor(rs.getString("com_id_autor"));

                Estado estado = new Estado();
                estado.setEstadoId(rs.getInt("com_est_id"));
                estado.setEstadoNombre("vacio");
                comic.setComicEstado(estado);

                User usuario = new User();
                usuario.setUserId(rs.getInt("com_user_id"));
                usuario.setUserName("vacio");
                usuario.setUserPass("vacio");
                usuario.setUserNombre("vacio");
                usuario.setUserEmail("vacio");
                usuario.setUserFoto("vacio");
                usuario.setUserDescripcion("vacio");
                comic.setComicUser(usuario);

                comic.setComicDescripcion(rs.getString("com_descripcion"));
                comic.setComicFoto(rs.getString("com_tapa"));
                comic.setComicId(rs.getInt("com_id"));

                listaFav.add(comic);
                

            }
             stm.close();
            rs.close();

        } catch (SQLException ex) {
            System.out.println("Error al obtener el listado de comics");
        }
        
        return listaFav;
        
    }
    
    
     public ArrayList<Comic> getListaLeidos(int userID){
        
        ArrayList<Comic> listaLeidos = new ArrayList<>();
        
        try {
             
            ConnectionManager connectionManager = new ConnectionManager();
            Connection con = connectionManager.getConnection();
            Statement stm;
            ResultSet rs;
            String sql;

            sql = "SELECT * FROM lista_leidos, comic WHERE lista_leidos.user_leido_id = "+ userID +" AND lista_leidos.com_leido_id = comic.com_id";

            stm = con.createStatement();
            rs = stm.executeQuery(sql);

            while (rs.next()) {
                Comic comic = new Comic();

                comic.setComicTitulo(rs.getString("com_titulo"));

                Categoria categoria = new Categoria();
                categoria.setCatID(rs.getInt("com_cat_id"));
                categoria.setCatNombre("vacio");
                comic.setComicCategoria(categoria);

               
                comic.setComicAutor(rs.getString("com_id_autor"));

                Estado estado = new Estado();
                estado.setEstadoId(rs.getInt("com_est_id"));
                estado.setEstadoNombre("vacio");
                comic.setComicEstado(estado);

                User usuario = new User();
                usuario.setUserId(rs.getInt("com_user_id"));
                usuario.setUserName("vacio");
                usuario.setUserPass("vacio");
                usuario.setUserNombre("vacio");
                usuario.setUserEmail("vacio");
                usuario.setUserFoto("vacio");
                usuario.setUserDescripcion("vacio");
                comic.setComicUser(usuario);

                comic.setComicDescripcion(rs.getString("com_descripcion"));
                comic.setComicFoto(rs.getString("com_tapa"));
                comic.setComicId(rs.getInt("com_id"));

                listaLeidos.add(comic);
                

            }
             stm.close();
            rs.close();

        } catch (SQLException ex) {
            System.out.println("Error al obtener el listado de comics");
        }
        
        return listaLeidos;
        
    }
     
     
          public ArrayList<Comic> getListaPendientes(int userID){
        
        ArrayList<Comic> listaPendientes = new ArrayList<>();
        
        try {
             
            ConnectionManager connectionManager = new ConnectionManager();
            Connection con = connectionManager.getConnection();
            Statement stm;
            ResultSet rs;
            String sql;

            sql = "SELECT * FROM lista_pendientes, comic WHERE lista_pendientes.user_pendiente_id = "+ userID + " AND lista_pendientes.com_pendiente_id = comic.com_id";

            stm = con.createStatement();
            rs = stm.executeQuery(sql);

            while (rs.next()) {
                Comic comic = new Comic();

                comic.setComicTitulo(rs.getString("com_titulo"));

                Categoria categoria = new Categoria();
                categoria.setCatID(rs.getInt("com_cat_id"));
                categoria.setCatNombre("vacio");
                comic.setComicCategoria(categoria);

                
                comic.setComicAutor(rs.getString("com_id_autor"));

                Estado estado = new Estado();
                estado.setEstadoId(rs.getInt("com_est_id"));
                estado.setEstadoNombre("vacio");
                comic.setComicEstado(estado);

                User usuario = new User();
                usuario.setUserId(rs.getInt("com_user_id"));
                usuario.setUserName("vacio");
                usuario.setUserPass("vacio");
                usuario.setUserNombre("vacio");
                usuario.setUserEmail("vacio");
                usuario.setUserFoto("vacio");
                usuario.setUserDescripcion("vacio");
                comic.setComicUser(usuario);

                comic.setComicDescripcion(rs.getString("com_descripcion"));
                comic.setComicFoto(rs.getString("com_tapa"));
                comic.setComicId(rs.getInt("com_id"));

                listaPendientes.add(comic);
                

            }
             stm.close();
            rs.close();

        } catch (SQLException ex) {
            System.out.println("Error al obtener el listado de comics");
        }
        
        return listaPendientes;
        
    }
          
           public void AgregarFav(int idComic, int idUser){
        
        try {

            ConnectionManager connectionManager = new ConnectionManager();
            Connection con = connectionManager.getConnection();
            PreparedStatement stm;
            
            String sql;

            sql = "INSERT INTO lista_fav (user_id_fav, comic_id_fav)"
                    + "VALUES (?,?)";

            stm = con.prepareStatement(sql);
            
            stm.setInt(1, idUser);
            stm.setInt(2, idComic);
            
            stm.executeUpdate();
            
            stm.close();
            con.close();
            
        } catch (SQLException ex) {
            System.out.println("Error al obtener comic");
        }
    }
           
            public void AgregarLeido(int idComic, int idUser){
        
        try {

            ConnectionManager connectionManager = new ConnectionManager();
            Connection con = connectionManager.getConnection();
            PreparedStatement stm;
            
            String sql;

            sql = "INSERT INTO lista_leidos (user_leido_id, com_leido_id)"
                    + "VALUES (?,?)";

            stm = con.prepareStatement(sql);
            
            stm.setInt(1, idUser);
            stm.setInt(2, idComic);
            
            stm.executeUpdate();
            
            stm.close();
            con.close();
            
        } catch (SQLException ex) {
            System.out.println("Error al obtener comic");
        }
    }
            
            public void AgregarPendiente(int idComic, int idUser){
        
        try {

            ConnectionManager connectionManager = new ConnectionManager();
            Connection con = connectionManager.getConnection();
            PreparedStatement stm;
            
            String sql;

            sql = "INSERT INTO lista_pendientes (user_pendiente_id, com_pendiente_id)"
                    + "VALUES (?,?)";

            stm = con.prepareStatement(sql);
            
            stm.setInt(1, idUser);
            stm.setInt(2, idComic);
            
            stm.executeUpdate();
            
            stm.close();
            con.close();
            
        } catch (SQLException ex) {
            System.out.println("Error al obtener comic");
        }
    }
    
      public ArrayList<Comic> getPublicUser(int userID){
        
        ArrayList<Comic> publicUser = new ArrayList<>();
        
        try {
             
            ConnectionManager connectionManager = new ConnectionManager();
            Connection con = connectionManager.getConnection();
            Statement stm;
            ResultSet rs;
            String sql;

            sql = "SELECT * FROM comic WHERE comic.com_user_id = " + userID ;

            stm = con.createStatement();
            rs = stm.executeQuery(sql);

            while (rs.next()) {
                Comic comic = new Comic();

                comic.setComicTitulo(rs.getString("com_titulo"));

                Categoria categoria = new Categoria();
                categoria.setCatID(rs.getInt("com_cat_id"));
                categoria.setCatNombre("vacio");
                comic.setComicCategoria(categoria);

                
                comic.setComicAutor(rs.getString("com_id_autor"));

                Estado estado = new Estado();
                estado.setEstadoId(rs.getInt("com_est_id"));
                estado.setEstadoNombre("vacio");
                comic.setComicEstado(estado);

                User usuario = new User();
                usuario.setUserId(rs.getInt("com_user_id"));
                usuario.setUserName("vacio");
                usuario.setUserPass("vacio");
                usuario.setUserNombre("vacio");
                usuario.setUserEmail("vacio");
                usuario.setUserFoto("vacio");
                usuario.setUserDescripcion("vacio");
                comic.setComicUser(usuario);

                comic.setComicDescripcion(rs.getString("com_descripcion"));
                comic.setComicFoto(rs.getString("com_tapa"));
                comic.setComicId(rs.getInt("com_id"));

                publicUser.add(comic);
                

            }
             stm.close();
            rs.close();

        } catch (SQLException ex) {
            System.out.println("Error al obtener el listado de comics");
        }
        
        return publicUser;
        
    }
      
      
      public void eliminarComicFav(int idComic, int idUser){
         try{ 
         ConnectionManager connectionManager = new ConnectionManager();
         Connection con = connectionManager.getConnection();
         PreparedStatement stm;
            
         String sql;
          
          sql = "DELETE FROM `lista_fav` WHERE user_id_fav = " + idUser + " AND comic_id_fav = " + idComic ; 
          
          stm = con.prepareStatement(sql);
            
            
            stm.executeUpdate();
            
            stm.close();
            con.close(); 
      }
         catch (SQLException ex) {
            System.out.println("Error al eliminar");
        }
      }
      
      public void eliminarComicLeidos(int idComic, int idUser){
         try{ 
         ConnectionManager connectionManager = new ConnectionManager();
         Connection con = connectionManager.getConnection();
         PreparedStatement stm;
            
         String sql;
          
          sql = "DELETE FROM `lista_leidos` WHERE user_leido_id = " + idUser + " AND com_leido_id = " + idComic ; 
          
          stm = con.prepareStatement(sql);
            
            
            stm.executeUpdate();
            
            stm.close();
            con.close(); 
      }
         catch (SQLException ex) {
            System.out.println("Error al eliminar");
        }
      }
      
       public void eliminarComicPendientes(int idComic, int idUser){
         try{ 
         ConnectionManager connectionManager = new ConnectionManager();
         Connection con = connectionManager.getConnection();
         PreparedStatement stm;
            
         String sql;
          
          sql = "DELETE FROM `lista_pendientes` WHERE user_pendiente_id = " + idUser + " AND com_pendiente_id = " + idComic ; 
          
          stm = con.prepareStatement(sql);
            
            
            stm.executeUpdate();
            
            stm.close();
            con.close(); 
      }
         catch (SQLException ex) {
            System.out.println("Error al eliminar");
        }
      }
    
}
