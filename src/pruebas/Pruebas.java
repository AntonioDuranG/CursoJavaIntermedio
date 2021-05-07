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
import java.util.List;

/**
 *
 * @author freet
 */
public class Pruebas {

    //BEAN SE CONECTA AL JSF Y PUEDE TENER PROCESOS
    public static void main(String[] args) {
        DBConnectionManager.initInstance("IP", "USER", "PASSWORD", "pruebas");

//        if (args.length < 6) {
//            System.out.println("No Cumple con el total de Argumentos-----");
//            System.out.println("1> database");
//            System.out.println("2> user");
//            System.out.println("3> password");
//            System.out.println("4> nombre");
//            System.out.println("5> apaterno");
//            System.out.println("6> amaterno");
//        } else {
//            int i = 0;
////        
//            String database = args[i++];//<--cambiar a tu base de datos
//            String ip = "localhost";
//            String usuariomysql = "root";
//            String passwordmysql = "necron2019";
//
//            String user = args[i++];
//            String pasword = args[i++];
//            String nombre = args[i++];
//            String apaterno = args[i++];
//            String amaterno = args[i++];
//
//            DBConnectionManager.initInstance(ip, usuariomysql, passwordmysql, database);
//
//            UsuarioDAO controlador = new UsuarioDAO();
//
//            List<UsuarioTO> usuarios = new ArrayList<>();
//            usuarios.add(new UsuarioTO(user, pasword, nombre, apaterno, amaterno));
//
//            boolean isvalidate = controlador.crearUsuarios(usuarios);
//            System.out.println("Exitoso?: " + isvalidate);
//        }
        // cambiar el archivo db.properties
        //La IP, user y password
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
//        UsuarioDAO controlador = new UsuarioDAO();
//        List<UsuarioTO> usuarios = controlador.consultarUsuarios();
//        Iterator<UsuarioTO> iter = usuarios.iterator();
//        int i = 0;
//        while (iter.hasNext()) {
//            UsuarioTO u = iter.next();
//            System.out.println("Bienvenido!!! " + u.getApterno() + " " + u.getAmaterno() + " " + u.getNombre() + " | " + u.getFecharegistro());
//        }
//        Map<String, UsuarioTO> mapa = controlador.consultarUsuariosMapa();
//        Iterator<UsuarioTO> iter = mapa.values().iterator();
//        while (iter.hasNext()) {
//            UsuarioTO u = iter.next();
//            System.out.println("Bienvenido!!! " + u.getApterno() + " " + u.getAmaterno() + " " + u.getNombre());
//        }
//        String llave = "admin76 | admins76";
//        if (mapa.get(llave) == null) {
//            System.out.println("NoExisteElUsuario");
//        } else {
//            System.out.println("El Usuario si exste con el ID: " + mapa.get(llave).getIdusuario());
//        }

        Hilo h = new Hilo();
        h.start();
    }

}
