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
public class CategoriaDAO {
    
    public ArrayList<Comic> getListadoCategoria(int idCat){
        
         ArrayList<Comic> listaComics = new ArrayList<>(); 
         
         try {

            ConnectionManager connectionManager = new ConnectionManager();
            Connection con = connectionManager.getConnection();
            Statement stm;
            ResultSet rs;
            String sql;

            sql = "SELECT * FROM comic, categorias, autor, estados, users WHERE" +
                    " com_cat_id = cat_id AND com_est_id = est_id AND "+
                    "com_user_id = user_id AND categorias.cat_id = "+ idCat;

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
    
    
     public void guardarCategoria(String categoria){
        
        try {

            ConnectionManager connectionManager = new ConnectionManager();
            Connection con = connectionManager.getConnection();
            PreparedStatement stm;
            
            String sql;

            sql = "INSERT INTO categorias (cat_nombre)"
                    + "VALUES (?)";

            stm = con.prepareStatement(sql);
            
            stm.setString(1, categoria);
            
            
            
            stm.executeUpdate();
            
            stm.close();
            con.close();
            
        } catch (SQLException ex) {
            System.out.println("Error al obtener comic");
        }
    }
     
     public void eliminarCategoria(int idCat){
        try {

            ConnectionManager connectionManager = new ConnectionManager();
            Connection con = connectionManager.getConnection();
            PreparedStatement stm;
            
            String sql;

            sql = "DELETE FROM `categorias` WHERE cat_id = " + idCat;

            stm = con.prepareStatement(sql);
            
            
            stm.executeUpdate();
            
            stm.close();
            con.close();
            
        } catch (SQLException ex) {
            System.out.println("Error al eliminar");
        }
    }
    
}
