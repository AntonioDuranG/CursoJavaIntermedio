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
public class PerfilTO {

    private int idperfil;
    private String nombre;

    private boolean catalogousuarios;
    private boolean catalogoperfiles;
    private boolean catalogollantas;

    public PerfilTO(int idperfil, String nombre, int catalogousuarios, int catalogoperfiles, int catalogollantas) {
        this.idperfil = idperfil;
        this.nombre = nombre;
        this.catalogousuarios = catalogousuarios == 1;
        this.catalogoperfiles = catalogoperfiles == 1;
        this.catalogollantas = catalogollantas == 1;
    }

    public int getIdperfil() {
        return idperfil;
    }

    public String getNombre() {
        return nombre;
    }

    public boolean isCatalogousuarios() {
        return catalogousuarios;
    }

    public boolean isCatalogoperfiles() {
        return catalogoperfiles;
    }

    public boolean isCatalogollantas() {
        return catalogollantas;
    }

}
