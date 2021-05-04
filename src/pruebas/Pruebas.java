/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebas;

import com.necron.controladores.UsuarioDAO;
import com.necron.database.DBConnectionManager;
import com.necron.to.UsuarioTO;

/**
 *
 * @author freet
 */
public class Pruebas {

    public static void main(String[] args) {

        String database = "pruebas";
        DBConnectionManager.initInstance(database);

        UsuarioDAO dao = new UsuarioDAO();
        UsuarioTO usuario = dao.consultar("admin", "admin");
        System.out.println("Bienvenido!!! " + usuario.getApterno() + " " + usuario.getAmaterno() + " " + usuario.getNombre());
    }

}
