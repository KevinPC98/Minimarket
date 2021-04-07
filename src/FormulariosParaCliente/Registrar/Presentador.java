/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FormulariosParaCliente.Registrar;

import BaseInternalFrame.BasePresentador;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DIEGO
 */
public class Presentador extends BasePresentador<Interface.vista> implements Interface.presenter{

    public Presentador(Interface.vista vista) {
        super(vista);
    }
    
    public void registrarCliente(String nombre,String apellidoP,String apellidoM, String direccion, String telefono,String dni){
       
        if (nombre.equals("") || telefono.equals("")|| direccion.equals("")|| apellidoM.equals("")
                || apellidoP.equals("") || dni.equals("")){
            vista.showMensaje("Debe llenar todos los campos \n","AVISO!");
        }else {
            try {
                adminDataBase.crearNuevoCliente(nombre,apellidoP,apellidoM, direccion, telefono,dni);
                vista.showMensaje("Los valores han sido agregados a la base de datos ","AVISO!");
            } catch (SQLException ex) {
                System.out.println("Error al agregar el Cliente");
                Logger.getLogger(RegistrarCliente.class.getName()).log(Level.SEVERE, null, ex);
            }
            vista.showMensaje("Registro exitoso!","AVISO!");
        }

    }
}
