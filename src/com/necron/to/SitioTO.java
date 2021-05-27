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
public class SitioTO {

    private int idsitio;
    private String nombre;

    public SitioTO(int idsitio, String nombre) {
        this.idsitio = idsitio;
        this.nombre = nombre;
    }

    public int getIdsitio() {
        return idsitio;
    }

    public String getNombre() {
        return nombre;
    }

}
