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
public class Categoria {
    private int catID;
    private String catNombre;

    public Categoria() {
    }

    public Categoria(int catID, String catNombre) {
        this.catID = catID;
        this.catNombre = catNombre;
    }

    public int getCatID() {
        return catID;
    }

    public void setCatID(int catID) {
        this.catID = catID;
    }

    public String getCatNombre() {
        return catNombre;
    }

    public void setCatNombre(String catNombre) {
        this.catNombre = catNombre;
    }
    
    
    
}
