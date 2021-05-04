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
public class LlantaTO {

    private int idllanta;
    private int posicion;
    private String tag;
    private Date fechaadquisicion;
    private Date fechalectura;

    public LlantaTO(int idllanta, int posicion, String tag, Date fechaadquisicion, Date fechalectura) {
        this.idllanta = idllanta;
        this.posicion = posicion;
        this.tag = tag;
        this.fechaadquisicion = fechaadquisicion;
        this.fechalectura = fechalectura;
    }

    public LlantaTO(int idllanta) {
        this.idllanta = idllanta;
    }

    public LlantaTO() {
    }

    public LlantaTO(int posicion, String tag) {
        this.posicion = posicion;
        this.tag = tag;
    }

    public LlantaTO(Date fechaadquisicion, Date fechalectura) {
        this.fechaadquisicion = fechaadquisicion;
        this.fechalectura = fechalectura;
    }

    public int getIdllanta() {
        return idllanta;
    }

    public int getPosicion() {
        return posicion;
    }

    public String getTag() {
        return tag;
    }

    public Date getFechaadquisicion() {
        return fechaadquisicion;
    }

    public Date getFechalectura() {
        return fechalectura;
    }

    public void setIdllanta(int idllanta) {
        this.idllanta = idllanta;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public void setFechaadquisicion(Date fechaadquisicion) {
        this.fechaadquisicion = fechaadquisicion;
    }

    public void setFechalectura(Date fechalectura) {
        this.fechalectura = fechalectura;
    }

}
