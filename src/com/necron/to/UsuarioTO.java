/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.necron.to;

/**
 *
 * @author freet
 */
public class UsuarioTO {

    private int idusuario;

    private String nombre;
    private String apterno;
    private String amaterno;

    public UsuarioTO(int idusuario, String nombre, String apterno, String amaterno) {
        this.idusuario = idusuario;
        this.nombre = nombre;
        this.apterno = apterno;
        this.amaterno = amaterno;
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

}
