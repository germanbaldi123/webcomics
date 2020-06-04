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


public class ComicDAO {
    
    public ArrayList<Comic> getListadoComic(){
        
         ArrayList<Comic> listaComics = new ArrayList<>(); 
         
         try {

            ConnectionManager connectionManager = new ConnectionManager();
            Connection con = connectionManager.getConnection();
            Statement stm;
            ResultSet rs;
            String sql;

            sql = "SELECT * FROM comic, categorias, estados, users WHERE" +
                    " com_cat_id = cat_id AND com_est_id = est_id AND "+
                    " com_user_id = user_id ";

            stm = con.createStatement();
            rs = stm.executeQuery(sql);

            
          

            while (rs.next()) {
                Comic comic = new Comic();

                comic.setComicTitulo(rs.getString("com_titulo"));

                Categoria categoria = new Categoria();
                categoria.setCatID(rs.getInt("cat_id"));
                categoria.setCatNombre(rs.getString("cat_nombre"));
                comic.setComicCategoria(categoria);

               
                comic.setComicAutor(rs.getString("com_id_autor"));

                Estado estado = new Estado();
                estado.setEstadoId(rs.getInt("est_id"));
                estado.setEstadoNombre(rs.getString("est_nombre"));
                comic.setComicEstado(estado);

                User usuario = new User();
                usuario.setUserId(rs.getInt("user_id"));
                usuario.setUserName(rs.getString("username"));
                usuario.setUserPass(rs.getString("user_pass"));
                usuario.setUserNombre(rs.getString("user_nombre"));
                usuario.setUserNombre(rs.getString("user_apellido"));
                usuario.setUserEmail(rs.getString("user_email"));
                usuario.setUserFoto(rs.getString("user_foto"));
                usuario.setUserDescripcion(rs.getString("user_desc"));
                comic.setComicUser(usuario);

                comic.setComicDescripcion(rs.getString("com_descripcion"));
                comic.setComicFoto(rs.getString("com_tapa"));
                comic.setComicId(rs.getInt("com_id"));
                comic.setComicFecha(rs.getString("fecha"));

                listaComics.add(comic);
                

            }
             stm.close();
            rs.close();

        } catch (SQLException ex) {
            System.out.println("Error al obtener el listado de comics");
        }
        
        return listaComics;
    }
    
    
     public ArrayList<Comic> buscarComic(String terminoBuscado){
        
         ArrayList<Comic> listaComics = new ArrayList<>(); 
         
         try {

            ConnectionManager connectionManager = new ConnectionManager();
            Connection con = connectionManager.getConnection();
            Statement stm;
            ResultSet rs;
            String sql;

            sql = "SELECT * FROM comic, categorias, estados, users WHERE" +
                    " com_titulo LIKE '%" + terminoBuscado + "%'" +
                    " AND com_cat_id = cat_id AND com_est_id = est_id AND "+
                    " com_user_id = user_id ";

            stm = con.createStatement();
            rs = stm.executeQuery(sql);

            
          

            while (rs.next()) {
                Comic comic = new Comic();

                comic.setComicTitulo(rs.getString("com_titulo"));

                Categoria categoria = new Categoria();
                categoria.setCatID(rs.getInt("cat_id"));
                categoria.setCatNombre(rs.getString("cat_nombre"));
                comic.setComicCategoria(categoria);

               
                comic.setComicAutor(rs.getString("com_id_autor"));

                Estado estado = new Estado();
                estado.setEstadoId(rs.getInt("est_id"));
                estado.setEstadoNombre(rs.getString("est_nombre"));
                comic.setComicEstado(estado);

                User usuario = new User();
                usuario.setUserId(rs.getInt("user_id"));
                usuario.setUserName(rs.getString("username"));
                usuario.setUserPass(rs.getString("user_pass"));
                usuario.setUserNombre(rs.getString("user_nombre"));
                usuario.setUserNombre(rs.getString("user_apellido"));
                usuario.setUserEmail(rs.getString("user_email"));
                usuario.setUserFoto(rs.getString("user_foto"));
                usuario.setUserDescripcion(rs.getString("user_desc"));
                comic.setComicUser(usuario);

                comic.setComicDescripcion(rs.getString("com_descripcion"));
                comic.setComicFoto(rs.getString("com_tapa"));
                comic.setComicId(rs.getInt("com_id"));
                comic.setComicFecha(rs.getString("fecha"));

                listaComics.add(comic);
                

            }
             stm.close();
            rs.close();

        } catch (SQLException ex) {
            System.out.println("Error al obtener el listado de comics");
        }
        
        return listaComics;
    }
    
    public ArrayList<Comic> getListadoCat(int idCat){
        
         ArrayList<Comic> listaComicsCat = new ArrayList<>(); 
         
         try {

            ConnectionManager connectionManager = new ConnectionManager();
            Connection con = connectionManager.getConnection();
            Statement stm;
            ResultSet rs;
            String sql;

            sql = "SELECT * FROM comic, categorias, users, estados  WHERE comic.com_cat_id = " + idCat + " AND comic.com_est_id = estados.est_id AND comic.com_est_id = estados.est_id AND comic.com_user_id = users.user_id AND comic.com_cat_id = categorias.cat_id";

            stm = con.createStatement();
            rs = stm.executeQuery(sql);

            
          

            while (rs.next()) {
                Comic comic = new Comic();

                comic.setComicTitulo(rs.getString("com_titulo"));

                Categoria categoria = new Categoria();
                categoria.setCatID(rs.getInt("cat_id"));
                categoria.setCatNombre(rs.getString("cat_nombre"));
                comic.setComicCategoria(categoria);

                
                comic.setComicAutor(rs.getString("com_id_autor"));

                Estado estado = new Estado();
                estado.setEstadoId(rs.getInt("est_id"));
                estado.setEstadoNombre(rs.getString("est_nombre"));
                comic.setComicEstado(estado);

                User usuario = new User();
                usuario.setUserId(rs.getInt("user_id"));
                usuario.setUserName(rs.getString("username"));
                usuario.setUserPass(rs.getString("user_pass"));
                usuario.setUserNombre(rs.getString("user_nombre"));
                usuario.setUserNombre(rs.getString("user_apellido"));
                usuario.setUserEmail(rs.getString("user_email"));
                usuario.setUserFoto(rs.getString("user_foto"));
                usuario.setUserDescripcion(rs.getString("user_desc"));
                comic.setComicUser(usuario);

                comic.setComicDescripcion(rs.getString("com_descripcion"));
                comic.setComicFoto(rs.getString("com_tapa"));
                comic.setComicId(rs.getInt("com_id"));
                comic.setComicFecha(rs.getString("fecha"));

                listaComicsCat.add(comic);
                

            }
             stm.close();
            rs.close();

        } catch (SQLException ex) {
            System.out.println("Error al obtener el listado de comics");
        }
        
        return listaComicsCat;
    }
    
    
    public Comic getComic(int idComic){
        
        
         Comic comic = new Comic();
         
         try {

            ConnectionManager connectionManager = new ConnectionManager();
            Connection con = connectionManager.getConnection();
            Statement stm;
            ResultSet rs;
            String sql;

            sql = "SELECT * FROM comic, categorias, estados, users" + 
                    " WHERE com_cat_id = cat_id AND com_est_id = est_id"+
                    " AND com_user_id = user_id AND com_id = " + idComic;

            stm = con.createStatement();
            rs = stm.executeQuery(sql);

            
          

           rs.next(); 
                

                comic.setComicTitulo(rs.getString("com_titulo"));

                Categoria categoria = new Categoria();
                categoria.setCatID(rs.getInt("cat_id"));
                categoria.setCatNombre(rs.getString("cat_nombre"));
                comic.setComicCategoria(categoria);

                
                comic.setComicAutor(rs.getString("com_id_autor"));

                Estado estado = new Estado();
                estado.setEstadoId(rs.getInt("est_id"));
                estado.setEstadoNombre(rs.getString("est_nombre"));
                comic.setComicEstado(estado);

                User usuario = new User();
                usuario.setUserId(rs.getInt("user_id"));
                usuario.setUserName(rs.getString("username"));
                usuario.setUserPass(rs.getString("user_pass"));
                usuario.setUserNombre(rs.getString("user_nombre"));
                usuario.setUserNombre(rs.getString("user_apellido"));
                usuario.setUserEmail(rs.getString("user_email"));
                usuario.setUserFoto(rs.getString("user_foto"));
                usuario.setUserDescripcion(rs.getString("user_desc"));
                comic.setComicUser(usuario);

                comic.setComicDescripcion(rs.getString("com_descripcion"));
                comic.setComicFoto(rs.getString("com_tapa"));
                comic.setComicId(rs.getInt("com_id"));
                comic.setComicFecha(rs.getString("fecha"));

        
            stm.close();
            rs.close();

        } catch (SQLException ex) {
            System.out.println("Error al obtener comic");
        }
        
        return comic; 
    }
    
    public void guardarComic(Comic comic){
        
        try {

            ConnectionManager connectionManager = new ConnectionManager();
            Connection con = connectionManager.getConnection();
            PreparedStatement stm;
            
            String sql;

            sql = "INSERT INTO comic (com_titulo, com_cat_id, com_est_id, com_id_autor, com_user_id, com_descripcion, com_tapa, fecha)"
                    + "VALUES (?,?,?,?,?,?,?,?)";

            stm = con.prepareStatement(sql);
            
            stm.setString(1, comic.getComicTitulo());
            stm.setInt(2, comic.getComicCategoria().getCatID());
            stm.setInt(3, comic.getComicEstado().getEstadoId());
            stm.setString(4, comic.getComicAutor());
            stm.setInt(5, comic.getComicUser().getUserId());
            stm.setString(6, comic.getComicDescripcion());
            stm.setString(7, comic.getComicFoto());
            stm.setString(8, comic.getComicFecha());
            
            
            stm.executeUpdate();
            
            stm.close();
            con.close();
            
        } catch (SQLException ex) {
            System.out.println("Error al obtener comic");
        }
    }
    
    
    
    public void editarComic(Comic comic){
        
        try {

            ConnectionManager connectionManager = new ConnectionManager();
            Connection con = connectionManager.getConnection();
            PreparedStatement stm;
            
            String sql;

            sql = "UPDATE `comic` SET com_titulo=?, com_cat_id=?, com_est_id=?, com_id_autor=?, com_descripcion=?, com_tapa=?, fecha=? WHERE com_id = " + comic.getComicId();

            stm = con.prepareStatement(sql);
            
            stm.setString(1, comic.getComicTitulo());
            stm.setInt(2, comic.getComicCategoria().getCatID());
            stm.setInt(3, comic.getComicEstado().getEstadoId());
            stm.setString(4, comic.getComicAutor());
            stm.setString(5, comic.getComicDescripcion());
            stm.setString(6, comic.getComicFoto());
            stm.setString(7, comic.getComicFecha());
            
            
            stm.executeUpdate();
            
            stm.close();
            con.close();
            
        } catch (SQLException ex) {
            System.out.println("Error al obtener comic");
        }
    }
    
    public void eliminarComic(int idComic){
        try {

            ConnectionManager connectionManager = new ConnectionManager();
            Connection con = connectionManager.getConnection();
            PreparedStatement stm;
            
            String sql;

            sql = "DELETE FROM `comic` WHERE com_id = " + idComic;

            stm = con.prepareStatement(sql);
            
            
            stm.executeUpdate();
            
            stm.close();
            con.close();
            
        } catch (SQLException ex) {
            System.out.println("Error al eliminar");
        }
    }
}
