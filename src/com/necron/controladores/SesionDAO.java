/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.necron.controladores;

import com.necron.database.ConnectionUtil;
import com.necron.database.DBConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author freet
 */
public class SesionDAO {

    public List<String> consultarUsuariosNotificaciones() {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<String> emails = new ArrayList<>();
        try {
            con = DBConnectionManager.getInstance().getConnection();
            ps = con.prepareStatement(Querys.QUERY_USUARIOS_NOTIFCACIONES);
            rs = ps.executeQuery();
            while (rs.next()) {
                emails.add(rs.getString("MAIL"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionUtil.endConnection(rs, ps, con, "SesionDAO.consultarUsuariosNotificaciones");
        }
        return emails;
    }
}
