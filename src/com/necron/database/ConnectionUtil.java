/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.necron.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author add
 */
public class ConnectionUtil {

    public static boolean endConnection(ResultSet rs, PreparedStatement ps, Connection con, String operacion) {
        if (rs != null) {
            try {
                rs.close();
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
        if (ps != null) {
            try {
                ps.close();
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
        if (con != null) {
            try {
                con.close();
                DBConnectionManager.conexionesTotalesAbiertas--;
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
        return true;
    }
}
