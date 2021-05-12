/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.necron.util;

import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.codec.binary.Hex;

/**
 *
 * @author freet
 */
public class Util {

    private final static SimpleDateFormat SDF_TIEMPO = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
//    
    private final static String NUMEROS = "0123456789";

    private final static String MAYUSCULAS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    private final static String MINUSCULAS = "abcdefghijklmnopqrstuvwxyz";

    public static String getHoy() {
        return SDF_TIEMPO.format(new Date());
    }

    public static String encriptacion(String password) {
        MessageDigest md;
        try {
            md = MessageDigest.getInstance("SHA-1");
            md.update(password.getBytes());
            return Hex.encodeHexString(md.digest());
        } catch (Exception e) {
            return null;
        }
    }

    public static String getPassword() {
        return getPassword(NUMEROS + MAYUSCULAS + MINUSCULAS, 5);
    }

    public static String getPassword(String key, int length) {
        String pswd = "";

        for (int i = 0; i < length; i++) {
            pswd += (key.charAt((int) (Math.random() * key.length())));
        }

        return pswd.toUpperCase();
    }
}
