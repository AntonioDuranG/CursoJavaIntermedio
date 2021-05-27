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
public class LlantaTO {

    private int idllanta;
    private String tag;

    public LlantaTO(int idllanta, String tag) {
        this.idllanta = idllanta;
        this.tag = tag;
    }

    public LlantaTO(String tag) {
        this.tag = tag;
    }

    public int getIdllanta() {
        return idllanta;
    }

    public String getTag() {
        return tag;
    }

}
