/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.webcomics.model.entities;



import java.util.Date;

/**
 *
 * @author OUTLET
 */
public class Comic {
    private int comicId;
    private String comicTitulo;
    private String comicAutor;
    private Estado comicEstado;
    private Categoria comicCategoria;
    private User comicUser;
    private String comicFoto;
    private String comicDescripcion;
    private String comicFecha;

   

    public Comic() {
    }

    public Comic(int comicId, String comicTitulo, String comicAutor, Estado comicEstado, Categoria comicCategoria, User comicUser, String comicFoto, String comicDescripcion, String comicFecha) {
        this.comicId = comicId;
        this.comicTitulo = comicTitulo;
        this.comicAutor = comicAutor;
        this.comicEstado = comicEstado;
        this.comicCategoria = comicCategoria;
        this.comicUser = comicUser;
        this.comicFoto = comicFoto;
        this.comicDescripcion = comicDescripcion;
    }
    
 public String getComicFecha() {
        return comicFecha;
    }

    public void setComicFecha(String comicFecha) {
        this.comicFecha = comicFecha;
    }
    public int getComicId() {
        return comicId;
    }

    public void setComicId(int comicId) {
        this.comicId = comicId;
    }

    public String getComicTitulo() {
        return comicTitulo;
    }

    public void setComicTitulo(String comicTitulo) {
        this.comicTitulo = comicTitulo;
    }

    public String getComicAutor() {
        return comicAutor;
    }

    public void setComicAutor(String comicAutor) {
        this.comicAutor = comicAutor;
    }

    public Estado getComicEstado() {
        return comicEstado;
    }

    public void setComicEstado(Estado comicEstado) {
        this.comicEstado = comicEstado;
    }

    public Categoria getComicCategoria() {
        return comicCategoria;
    }

    public void setComicCategoria(Categoria comicCategoria) {
        this.comicCategoria = comicCategoria;
    }

    public User getComicUser() {
        return comicUser;
    }

    public void setComicUser(User comicUser) {
        this.comicUser = comicUser;
    }

    public String getComicFoto() {
        return comicFoto;
    }

    public void setComicFoto(String comicFoto) {
        this.comicFoto = comicFoto;
    }

    public String getComicDescripcion() {
        return comicDescripcion;
    }

    public void setComicDescripcion(String comicDescripcion) {
        this.comicDescripcion = comicDescripcion;
    }
    
    
            
    
}
