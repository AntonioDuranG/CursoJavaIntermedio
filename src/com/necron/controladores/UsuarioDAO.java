/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.necron.controladores;

import com.necron.database.ConnectionUtil;
import com.necron.database.DBConnectionManager;
import com.necron.to.PerfilTO;
import com.necron.to.UsuarioTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author freet
 */
public class UsuarioDAO {

    public Map<String, UsuarioTO> consultarUsuariosMapa() {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Map<String, UsuarioTO> mapa = new HashMap<>();

        try {
            con = DBConnectionManager.getInstance().getConnection();
            ps = con.prepareStatement(Querys.QUERY_USUARIOS);
            rs = ps.executeQuery();
            while (rs.next()) {
                String llave = rs.getString("USER") + " | " + rs.getString("PASSWORD"); ///llave
                mapa.put(llave,//<------indice o llabe
                        new UsuarioTO(
                                rs.getInt("IDUSUARIO"),
                                rs.getString("NOMBRE"),
                                rs.getString("APATERNO"),
                                rs.getString("AMATERNO"),
                                0,
                                new Date()));//<-- Objeto indexado

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionUtil.endConnection(rs, ps, con);
        }
        return mapa;
    }

    public List<UsuarioTO> consultarUsuarios() {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<UsuarioTO> usuarios = new ArrayList<>();

        try {
            con = DBConnectionManager.getInstance().getConnection();
            ps = con.prepareStatement(Querys.QUERY_USUARIOS);
            rs = ps.executeQuery();
            while (rs.next()) {

                PerfilTO p = new PerfilTO(
                        rs.getInt("IDPERFIL"),
                        rs.getString("PERFIL"),
                        rs.getInt("CATALOGOUSUARIOS"),
                        rs.getInt("CATALOGOPERFILES"),
                        rs.getInt("CATALOGOLLANTAS"));
//                
                usuarios.add(
                        new UsuarioTO(
                                rs.getInt("IDUSUARIO"),
                                rs.getString("NOMBRE"),
                                rs.getString("APATERNO"),
                                rs.getString("AMATERNO"),
                                rs.getInt("NOTIFICACIONES"),
                                p));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionUtil.endConnection(rs, ps, con);
        }
        return usuarios;
    }

    public UsuarioTO login(String user, String password) {
        Connection con = null; //mysql
        PreparedStatement ps = null; //ejecutas sentencias
        ResultSet rs = null; // recibe resultado

        try {
            con = DBConnectionManager.getInstance().getConnection();

            ps = con.prepareStatement(Querys.QUERY_LOGIN);
            ps.setString(1, user);
            ps.setString(2, password);
            rs = ps.executeQuery();
            if (rs.next()) {
                return new UsuarioTO(
                        rs.getInt("IDUSUARIO"),
                        rs.getString("NOMBRE"),
                        rs.getString("APATERNO"),
                        rs.getString("AMATERNO"),
                        rs.getInt("NOTIFICACIONES"),
                        new Date());
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionUtil.endConnection(rs, ps, con);
        }
        return null;
    }

    public boolean crearUsuarios(List<UsuarioTO> usuarios) {
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = DBConnectionManager.getInstance().getConnection();
            ps = con.prepareStatement(Querys.INSERT_USUARIO);
            for (UsuarioTO u : usuarios) {
                int i = 1;
                ps.setString(i++, u.getUser());
                ps.setString(i++, u.getPassword());
                ps.setString(i++, u.getNombre());
                ps.setString(i++, u.getApterno());
                ps.setString(i++, u.getAmaterno());
                ps.executeUpdate();
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionUtil.endConnection(null, ps, con);
        }
        return false;
    }

    public boolean crearUsuario(UsuarioTO u, String password) {
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = DBConnectionManager.getInstance().getConnection();
            ps = con.prepareStatement(Querys.INSERT_USUARIO);
            int i = 1;
            ps.setString(i++, u.getUser());
            ps.setString(i++, password);
            ps.setString(i++, u.getNombre());
            ps.setString(i++, u.getApterno());
            ps.setString(i++, u.getAmaterno());
            ps.setTimestamp(i++, new java.sql.Timestamp(new Date().getTime()));
            ps.setString(i++, u.getMail());
            ps.setInt(i++, u.isNotifiaciones() ? 1 : 0);
            ps.setInt(i++, u.getIdperfil());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionUtil.endConnection(null, ps, con);
        }
        return false;
    }

    public void consultarPerfilUsuario(UsuarioTO u) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = DBConnectionManager.getInstance().getConnection();
            ps = con.prepareStatement(Querys.QUERY_PERFIL_USUARIO);
            ps.setInt(1, u.getIdperfil());
            rs = ps.executeQuery();
            if (rs.next()) {
                PerfilTO p
                        = new PerfilTO(
                                rs.getInt("IDPERFIL"),
                                rs.getString("NOMBRE"),
                                rs.getInt("CATALOGOUSUARIOS"),
                                rs.getInt("CATALOGOPERFILES"),
                                rs.getInt("CATALOGOLLANTAS"));
                u.setPerfil(p);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionUtil.endConnection(rs, ps, con);
        }
    }
}
