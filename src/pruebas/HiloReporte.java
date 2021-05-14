/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebas;

import com.necron.controladores.UsuarioDAO;
import com.necron.to.UsuarioTO;
import com.necron.util.Mails;
import java.io.File;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;

/**
 *
 * @author freet
 */
public class HiloReporte extends Thread {

    private final String path;

    public HiloReporte(String path) {
        this.path = path + "prueba.csv";
    }

    @Override
    public void run() {
        UsuarioDAO controlador = new UsuarioDAO();
        while (true) {
            List<UsuarioTO> usuarios = controlador.consultarUsuarios();
            StringBuilder stb;
            try {
                File archivo = new File(path);
                FileWriter escribir = new FileWriter(archivo);
                for (UsuarioTO u : usuarios) {
                    stb = new StringBuilder();
                    stb.append(u.getApterno()).append(",").append(u.getAmaterno()).append(",").append(u.getNombre()).append(",")
                            .append(u.getPerfil().getNombre()).append(",").append(u.getPerfil().isCatalogousuarios() ? "SI" : "NO");
                    escribir.write(stb.toString());
                    escribir.write("\n");
                }
                escribir.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                byte[] archivo = Files.readAllBytes(Paths.get(path));
                Mails servidormail = new Mails();
                boolean isvalidate = servidormail.enviarNotificacionReporte(archivo);
                System.out.println("Exitoso! " + isvalidate);

            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("DuermeHiloreporte... " + new Date());
            dormir();
        }
    }

    private void dormir() {
        try {
            sleep(60000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
