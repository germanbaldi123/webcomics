/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.webcomics.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author OUTLET
 */
public class ConnectionManager {
 
    public Connection getConnection(){
        String user     = "root";
        String password = "";
        String bd       = "proyecto_comic";
        String host     = "localhost";
        String port     = "3306";
        String timeZone = "UTC";
        
        String url;
        
        Connection con = null;
        
        url = "jdbc:mysql://" + host + ":" + port + "/" + bd + "?user=" + user + "&password=" + password + "&serverTimezone=" + timeZone;
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver cargado correctamente!");
            
            con = DriverManager.getConnection( url );
            
            System.out.println("Conectado satisfactoriamente");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConnectionManager.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error al cargar el Driver de MySQL");
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionManager.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("error al conectar BD");
        }
        return con; 
    }
}
