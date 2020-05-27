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

/**
 *
 * @author OUTLET
 */
public class UserDAO {
    
    public void nuevoUser(User nuevoUser){
        
        
        try{
            ConnectionManager connection = new ConnectionManager();
            Connection con = connection.getConnection();
            
            PreparedStatement stm;
            
            String sql; 
            
            sql = "INSERT INTO users (username, user_nombre, user_apellido, user_email, user_pass, user_foto, user_desc)"
            + " VALUES (?, ?, ?, ?, ?, ?, ?)";
            
            stm = con.prepareStatement(sql);
            
            stm.setString(1, nuevoUser.getUserName());
            stm.setString(2, nuevoUser.getUserNombre());
            stm.setString(3, nuevoUser.getUserApellido());
            stm.setString(4, nuevoUser.getUserEmail());
            stm.setString(5, nuevoUser.getUserPass());
            stm.setString(6, nuevoUser.getUserFoto());
            stm.setString(7, nuevoUser.getUserDescripcion());
            
            stm.executeUpdate();
        
            stm.close();
            con.close();
            
            
         } catch (SQLException ex) {
            System.out.println("Error al registrar ususario");
        }
        
        
    }
    
    
    public User getUser(int idUser){
        
        
         
         User usuario = new User();
         
         try {

            ConnectionManager connectionManager = new ConnectionManager();
            Connection con = connectionManager.getConnection();
            Statement stm;
            ResultSet rs;
            String sql;

            sql = "SELECT * FROM `users` WHERE user_id = " + idUser;

            stm = con.createStatement();
            rs = stm.executeQuery(sql);

            
          
            
            rs.next(); 
               
                usuario.setUserId(rs.getInt("user_id"));
                usuario.setUserName(rs.getString("username"));
                usuario.setUserPass(rs.getString("user_pass"));
                usuario.setUserNombre(rs.getString("user_nombre"));
                usuario.setUserNombre(rs.getString("user_apellido"));
                usuario.setUserEmail(rs.getString("user_email"));
                usuario.setUserFoto(rs.getString("user_foto"));
                usuario.setUserDescripcion(rs.getString("user_desc"));
              

              

        
            stm.close();
            rs.close();

        } catch (SQLException ex) {
            System.out.println("Error al obtener user");
        }
         
        return usuario;    
    }
    
        public User getUserLogin(String username){
        
        
         
         User usuario = new User();
         
         try {

            ConnectionManager connectionManager = new ConnectionManager();
            Connection con = connectionManager.getConnection();
            PreparedStatement stm;
            ResultSet rs;
            String sql;

            sql = "SELECT * FROM `users` WHERE username = (?)" ;

            stm = con.prepareStatement(sql);
            stm.setString(1, username);
            rs = stm.executeQuery();

            
          
            
                rs.next();
                
               
                    
                     usuario.setUserId(rs.getInt("user_id"));
                usuario.setUserName(rs.getString("username"));
                usuario.setUserPass(rs.getString("user_pass"));
                usuario.setUserNombre(rs.getString("user_nombre"));
                usuario.setUserNombre(rs.getString("user_apellido"));
                usuario.setUserEmail(rs.getString("user_email"));
                usuario.setUserFoto(rs.getString("user_foto"));
                usuario.setUserDescripcion(rs.getString("user_desc"));
                    
            stm.close();
            rs.close();

        } catch (SQLException ex) {
            System.out.println("Error al obtener user");
        }
         
        return usuario;    
    }
    
    public void eliminarUsuario(int idUser){
          try {

            ConnectionManager connectionManager = new ConnectionManager();
            Connection con = connectionManager.getConnection();
            PreparedStatement stm;
            
            String sql;

            sql = "DELETE FROM `users` WHERE user_id = " + idUser;

            stm = con.prepareStatement(sql);
            
            
            stm.executeUpdate();
            
            stm.close();
            con.close();
            
        } catch (SQLException ex) {
            System.out.println("Error al obtener comic");
        }
    }
            
    
}
