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

    public ConnectionManagerPool() {
        init();
    }

    public Connection getConexion() {
        try {
            return ds.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private void init() {
        InputStream is = getClass().getResourceAsStream("/com/necron/database/db.properties");
        Properties dbProps = new Properties();
        try {
            dbProps.load(is);
        } catch (Exception e) {
            e.printStackTrace();
        }
//        StringBuilder stb = new StringBuilder();
//        stb.append("jdbc:mysql://")
//                .append(ip)
//                .append(":3306/")
//                .append(database)
//                .append("?useSSL=false");
//        System.out.println("URL: " + stb.toString());

        ds = getDataSource(
                dbProps.getProperty("mysql.driver"),
                dbProps.getProperty("mysql.user"),
                dbProps.getProperty("mysql.password"),
                dbProps.getProperty("mysql.url"),
                Integer.parseInt(dbProps.getProperty("mysql.maxconn")));
//        ds = getDataSource(user, password, stb.toString(), 50);

    }

    DataSource getDataSource(String driver, String user, String password, String url, int maxConexiones) {
        BasicDataSource basicDS = new BasicDataSource();
        basicDS.setDriverClassName(driver);
        basicDS.setUsername(user);
        basicDS.setPassword(password);
        basicDS.setUrl(url);
        basicDS.setMaxActive(maxConexiones);
        basicDS.setMaxIdle(2);
        basicDS.setMaxWait(60000);
        return basicDS;
    }
}
