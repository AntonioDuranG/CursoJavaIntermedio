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

    public static final String QUERY_LOGIN = "SELECT IDUSUARIO,NOMBRE,APATERNO,AMATERNO FROM pruebas.usuariostb where user = ? and password = ?";
}
