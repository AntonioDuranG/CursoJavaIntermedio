/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebas;

import com.necron.controladores.UsuarioDAO;
import com.necron.to.UsuarioTO;
import java.util.Date;

/**
 *
 * @author freet
 */
public class Hilo extends Thread {

    @Override
    public void run() {
        UsuarioDAO controlador = new UsuarioDAO();
        int i = 0;
        while (true) {
            controlador.crearUsuario(
                    new UsuarioTO(
                            "admin" + i,
                            "adminadmin" + i,
                            "usuario " + i,
                            "paterno " + i,
                            "materno " + i));
            i++;
            System.out.println("Durmiendo.... " + new Date());
            dormir();
        }
    }

    private void dormir() {
        try {
            sleep(10000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
