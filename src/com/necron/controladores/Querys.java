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

    public static final String QUERY_LOGIN = "SELECT IDUSUARIO,NOMBRE,APATERNO,AMATERNO,NOTIFICACIONES FROM usuariostb where user = ? and password = ? and ESTATUS = 1";

    public static final String QUERY_USUARIOS = "select "
            + "u.IDUSUARIO IDUSUARIO,"
            + "u.NOMBRE NOMBRE,"
            + "u.APATERNO APATERNO,"
            + "u.AMATERNO AMATERNO,"
            + "u.NOTIFICACIONES NOTIFICACIONES,"
            + "p.IDPERFIL IDPERFIL,"
            + "p.NOMBRE PERFIL,"
            + "p.CATALOGOUSUARIOS CATALOGOUSUARIOS,"
            + "p.CATALOGOPERFILES CATALOGOPERFILES,"
            + "p.CATALOGOLLANTAS CATALOGOLLANTAS "
            + "from usuariostb u inner join perfilestb p on u.IDPERFIL = p.IDPERFIL";

    public static final String INSERT_USUARIO = "insert into usuariostb (USER,PASSWORD,NOMBRE,APATERNO,AMATERNO,FECHAREGISTRO,MAIL,ESTATUS,NOTIFICACIONES,IDPERFIL) values (?,?,?,?,?,?,?,1,?,?)";

    public static final String QUERY_USUARIOS_NOTIFCACIONES = "select MAIL from usuariostb where ESTATUS = 1 and NOTIFICACIONES = 1";

    public static final String QUERY_PERFIL_USUARIO = "SELECT IDPERFIL,NOMBRE,CATALOGOUSUARIOS,CATALOGOPERFILES,CATALOGOLLANTAS FROM pruebas.perfilestb where IDPERFIL = ?";

    public static final String QUERY_ULTIMO_REGISTRO_TAG = "SELECT IDLLANTA FROM llantastb order by IDLLANTA desc limit 1";

    public static final String INSERT_TAG = "insert into llantastb (TAG,FECHAADQUISICION,ESTATUSINVENTARIO) values (?,?,?)";

    public static final String QUERY_TAG_DISPONIBLE = "select IDLLANTA,TAG from llantastb where ESTATUSINVENTARIO = -1 order by IDLLANTA asc limit 1";
}
