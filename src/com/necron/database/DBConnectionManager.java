/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.necron.database;

import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author add
 */
public class DBConnectionManager {

    private final static String BD_SERVICIO = "SERVICIO";
    private final Map<String, ConnectionManagerPool> mapaconexiones = new HashMap<>();
    private static DBConnectionManager instance = null;
    public static int conexionesTotalesAbiertas = 0;

    private DBConnectionManager() {
        init();
    }

    public static void initInstance() {
        if (instance == null) {
            instance = new DBConnectionManager();
        }
    }

    public static synchronized DBConnectionManager getInstance() {
        return instance;
    }

    private void init() {
        mapaconexiones.put(BD_SERVICIO, new ConnectionManagerPool());
    }

    public Connection getConnection() {
        ConnectionManagerPool connectionManager = mapaconexiones.get(BD_SERVICIO);
        if (connectionManager == null) {
            throw new IllegalArgumentException("Base de Datos no existe o no inicializada");
        }
        conexionesTotalesAbiertas++;
        return connectionManager.getConexion();
    }
//
//    public static int getConexionesTotalesAbiertas() {
//        return conexionesTotalesAbiertas;
//    }
//
//    public static void setConexionesTotalesAbiertas(int conexionesTotalesAbiertas) {
//        DBConnectionManager.conexionesTotalesAbiertas = conexionesTotalesAbiertas;
//    }
}
