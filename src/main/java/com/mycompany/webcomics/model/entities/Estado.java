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
public class Estado {
    private int estadoId;
    private String estadoNombre;

    public Estado() {
    }

    public Estado(int estadoId, String estadoNombre) {
        this.estadoId = estadoId;
        this.estadoNombre = estadoNombre;
    }

    public int getEstadoId() {
        return estadoId;
    }

    public void setEstadoId(int estadoId) {
        this.estadoId = estadoId;
    }

    public String getEstadoNombre() {
        return estadoNombre;
    }

    public void setEstadoNombre(String estadoNombre) {
        this.estadoNombre = estadoNombre;
    }
   
    
}
