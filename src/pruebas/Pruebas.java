/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebas;

import com.necron.controladores.UsuarioDAO;
import com.necron.database.DBConnectionManager;
import com.necron.to.UsuarioTO;
import java.util.Iterator;
import java.util.Map;

/**
 *
 * @author freet
 */
public class Pruebas {

    //BEAN SE CONECTA AL JSF Y PUEDE TENER PROCESOS
    public static void main(String[] args) {

        // cambiar el archivo db.properties
        //La IP, user y password
        
        String database = "pruebas";//<--cambiar a tu base de datos
        DBConnectionManager.initInstance(database);

        UsuarioDAO controlador = new UsuarioDAO();

//        List<UsuarioTO> usuarios = new ArrayList<>();
//        for (int i = 0; i < 100; i++) {
//            String user = "admin" + i;
//            String pasword = "admins" + i;
//            String nombre = "juan" + i;
//            String apaterno = "zaldivar" + i;
//            String amaterno = "roldan" + i;
////            
//            usuarios.add(
//                    new UsuarioTO(user, pasword, nombre, apaterno, amaterno)
//            );
////            
//        }
//        
//        boolean isvalidate = controlador.crearUsuarios(usuarios);
//        System.out.println("IsValidate: " + isvalidate);
//        List<UsuarioTO> usuarios = controlador.consultarUsuarios();
//        Iterator<UsuarioTO> iter = usuarios.iterator();
//        while (iter.hasNext()) {
//            UsuarioTO u = iter.next();
//            System.out.println("Bienvenido!!! " + u.getApterno() + " " + u.getAmaterno() + " " + u.getNombre());
//        }
        Map<String, UsuarioTO> mapa = controlador.consultarUsuariosMapa();
        Iterator<UsuarioTO> iter = mapa.values().iterator();
        while (iter.hasNext()) {
            UsuarioTO u = iter.next();
            System.out.println("Bienvenido!!! " + u.getApterno() + " " + u.getAmaterno() + " " + u.getNombre());
        }
        String llave = "admin76 | admins76";
        if (mapa.get(llave) == null) {
            System.out.println("NoExisteElUsuario");
        } else {
            System.out.println("El Usuario si exste con el ID: " + mapa.get(llave).getIdusuario());
        }

    }

}
