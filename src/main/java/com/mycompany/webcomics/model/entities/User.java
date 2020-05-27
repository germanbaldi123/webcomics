/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.webcomics.model.entities;

/**
 *
 * @author OUTLET
 */
public class User {
    private int userId;
    private String userName;
    private String userPass;
    private String userNombre;
    private String userApellido;
    private String userEmail;
    private String userFoto;
    private String userDescripcion;

    public User() {
    }

    public User(int userId, String userName, String userPass, String userNombre, String userApellido, String userEmail, String userFoto, String userDescripcion) {
        this.userId = userId;
        this.userName = userName;
        this.userPass = userPass;
        this.userNombre = userNombre;
        this.userApellido = userApellido;
        this.userEmail = userEmail;
        this.userFoto = userFoto;
        this.userDescripcion = userDescripcion;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPass() {
        return userPass;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }

    public String getUserNombre() {
        return userNombre;
    }

    public void setUserNombre(String userNombre) {
        this.userNombre = userNombre;
    }

    public String getUserApellido() {
        return userApellido;
    }

    public void setUserApellido(String userApellido) {
        this.userApellido = userApellido;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserFoto() {
        return userFoto;
    }

    public void setUserFoto(String userFoto) {
        this.userFoto = userFoto;
    }

    public String getUserDescripcion() {
        return userDescripcion;
    }

    public void setUserDescripcion(String userDescripcion) {
        this.userDescripcion = userDescripcion;
    }
    
    
    
    
}

