/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.necron.database;

import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;
import javax.sql.DataSource;
import org.apache.commons.dbcp.BasicDataSource;

/**
 *
 * @author add
 */
public class ConnectionManagerPool {

    private DataSource ds = null;

    public ConnectionManagerPool(String database) {
        init(database);
    }

    public Connection getConexion() {
        try {
            return ds.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private void init(String database) {
        InputStream is = getClass().getResourceAsStream("/com/necron/database/db.properties");
        Properties dbProps = new Properties();
        try {
            dbProps.load(is);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String url = dbProps.getProperty("mysql.url").replaceAll("database", database);
        System.out.println("URLDAB:: " + url);
        ds = getDataSource(dbProps.getProperty("mysql.user"),
                dbProps.getProperty("mysql.password"), url,
                Integer.parseInt(dbProps.getProperty("mysql.maxconn")));
    }

    DataSource getDataSource(String user, String password, String url, int maxConexiones) {
        BasicDataSource basicDS = new BasicDataSource();

        basicDS.setDriverClassName("com.mysql.jdbc.Driver");
        basicDS.setUsername(user);
        basicDS.setPassword(password);
        basicDS.setUrl(url);
        basicDS.setMaxActive(maxConexiones);
        basicDS.setMaxIdle(2);
        basicDS.setMaxWait(60000);
        return basicDS;
    }
}
