/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.necron.controladores;

import com.necron.database.ConnectionUtil;
import com.necron.database.DBConnectionManager;
import com.necron.to.LlantaTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import java.util.List;

/**
 *
 * @author freet
 */
public class ControladorLlanta implements ControladorDAO<LlantaTO> {

    @Override
    public boolean crear(LlantaTO llanta) {
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = DBConnectionManager.getInstance().getConnection();
            ps = con.prepareStatement(Querys.INSERT_TAG);
            ps.setString(1, llanta.getTag());
            ps.setTimestamp(2, new java.sql.Timestamp(new Date().getTime()));
            ps.setInt(3, -1);
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionUtil.endConnection(null, ps, con, this.getClass() + ".crear");
        }
        return false;
    }

    @Override
    public boolean editar(LlantaTO entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<LlantaTO> condultarEntities() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public LlantaTO consultar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int condultarUltimoRegistro() {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = DBConnectionManager.getInstance().getConnection();
            ps = con.prepareStatement(Querys.QUERY_ULTIMO_REGISTRO_TAG);
            rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt("IDLLANTA") + 1;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionUtil.endConnection(rs, ps, con, this.getClass() + ".condultarUltimoRegistro");
        }
        return 0;
    }

    @Override
    public String consultar() {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = DBConnectionManager.getInstance().getConnection();
            ps = con.prepareStatement(Querys.QUERY_TAG_DISPONIBLE);
            rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getString("TAG");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionUtil.endConnection(rs, ps, con, "");
        }
        return null;
    }

}
