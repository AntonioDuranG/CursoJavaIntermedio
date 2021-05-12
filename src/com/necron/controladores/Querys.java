/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.necron.controladores;

/**
 *
 * @author freet
 */
public class Querys {

    public static final String QUERY_LOGIN = "SELECT IDUSUARIO,NOMBRE,APATERNO,AMATERNO FROM usuariostb where user = ? and password = ? and ESTATUS = 1";

    public static final String QUERY_USUARIOS = "SELECT IDUSUARIO,USER,PASSWORD,NOMBRE,APATERNO,AMATERNO,FECHAREGISTRO FROM usuariostb";

    public static final String INSERT_USUARIO = "insert into usuariostb (USER,PASSWORD,NOMBRE,APATERNO,AMATERNO,FECHAREGISTRO,MAIL,ESTATUS) values (?,?,?,?,?,?,?,1)";
}
