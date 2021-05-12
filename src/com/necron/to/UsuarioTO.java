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
    private int idperfil;

    private String user;
    private String password;
    private String nombre;
    private String apterno;
    private String amaterno;
    private String mail;

    private PerfilTO perfil;

    private boolean notifiaciones;

    private Date fecharegistro;

    public UsuarioTO(int idusuario, String nombre, String apterno, String amaterno, int notificaciones, Date fecharegistro) {
        this.idusuario = idusuario;
        this.nombre = nombre;
        this.apterno = apterno;
        this.amaterno = amaterno;
        this.notifiaciones = notificaciones == 1;
        this.fecharegistro = fecharegistro;
    }

    public UsuarioTO(int idusuario, String nombre, String apterno, String amaterno, int notificaciones, PerfilTO perfil) {
        this.idusuario = idusuario;
        this.nombre = nombre;
        this.apterno = apterno;
        this.amaterno = amaterno;
        this.notifiaciones = notificaciones == 1;
        this.perfil = perfil;
    }

    public UsuarioTO(String user, String password, String nombre, String apterno, String amaterno, String mail, int idperfil, int notifiaciones) {
        this.user = user;
        this.password = password;
        this.nombre = nombre.trim().toUpperCase();
        this.apterno = apterno.trim().toUpperCase();
        this.amaterno = amaterno.trim().toUpperCase();
        this.mail = mail;
        this.idperfil = idperfil;
        this.notifiaciones = notifiaciones == 1;
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

    public String getMail() {
        return mail;
    }

    public boolean isNotifiaciones() {
        return notifiaciones;
    }

    public int getIdperfil() {
        return idperfil;
    }

    public PerfilTO getPerfil() {
        return perfil;
    }

    public void setPerfil(PerfilTO perfil) {
        this.perfil = perfil;
    }

}
