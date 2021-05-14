/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebas;

import com.necron.controladores.UsuarioDAO;
import com.necron.to.UsuarioTO;
import com.necron.util.Util;
import java.util.Date;

/**
 *
 * @author freet
 */
public class Hilo extends Thread {

    private int i = 0;

    public Hilo() {
    }

    @Override
    public void run() {
        UsuarioDAO controlador = new UsuarioDAO();
        while (true) {
            for (int j = 0; j < 5; j++) {
                String password = Util.encriptacion("password " + i);
                controlador.crearUsuario(
                        new UsuarioTO("user " + i, "password " + i, "nombre" + i, "apaterno " + i, "amatrno " + i, "mail " + i, 1, 0), password);
                i++;
            }
            System.out.println("DurmiendoHiloDatos.... " + new Date());
            dormir();
        }
    }

    private void dormir() {
        try {
            sleep(20000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
