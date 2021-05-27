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
public class OperadorTO {

    private int idoperador;
    private String nombre;

    public OperadorTO(int idoperador, String nombre) {
        this.idoperador = idoperador;
        this.nombre = nombre;
    }

    public int getIdoperador() {
        return idoperador;
    }

    public String getNombre() {
        return nombre;
    }

}
