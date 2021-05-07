/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.necron.to;

import java.util.Date;

/**
 *
 * @author freet
 */
public class UsuarioTO {

    private int idusuario;

    private String user;
    private String password;
    private String nombre;
    private String apterno;
    private String amaterno;

    private Date fecharegistro;

    public UsuarioTO(int idusuario, String nombre, String apterno, String amaterno, Date fecharegistro) {
        this.idusuario = idusuario;
        this.nombre = nombre;
        this.apterno = apterno;
        this.amaterno = amaterno;
        this.fecharegistro = fecharegistro;
    }

    public UsuarioTO(String user, String password, String nombre, String apterno, String amaterno) {
        this.user = user;
        this.password = password;
        this.nombre = nombre.trim().toUpperCase();
        this.apterno = apterno.trim().toUpperCase();
        this.amaterno = amaterno.trim().toUpperCase();
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }

    public int getIdusuario() {
        return idusuario;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApterno() {
        return apterno;
    }

    public String getAmaterno() {
        return amaterno;
    }

    public Date getFecharegistro() {
        return fecharegistro;
    }

}
