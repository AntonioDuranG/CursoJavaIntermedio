/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebas;

import com.necron.controladores.ControladorDAO;
import com.necron.controladores.ControladorLlanta;
import com.necron.database.DBConnectionManager;
import com.necron.to.LlantaTO;
import com.necron.util.Util;

/**
 *
 * @author freet
 */
public class TireControl {

    ControladorDAO controladorllanta;

    public static void main(String[] args) {
        DBConnectionManager.initInstance();
//        
        TireControl tc = new TireControl();
//        
        tc.controladorllanta = new ControladorLlanta();

        System.out.println("TagDisponible: " + tc.consultarTag());
//        boolean isvalidate = tc.registrartag();
//        System.out.println("Isvalidate? " + isvalidate);

    }

    private String consultarTag() {
        return controladorllanta.consultar();
    }

    private boolean registrartag() {
        int id = controladorllanta.condultarUltimoRegistro();
        String fecha = Util.getFechaTag();

        String tag = fecha + "000000000000000" + id;
        System.out.println("tag_: " + tag);

        return controladorllanta.crear(new LlantaTO(tag));
    }

}
