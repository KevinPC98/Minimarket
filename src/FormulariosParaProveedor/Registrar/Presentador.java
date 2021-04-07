/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FormulariosParaProveedor.Registrar;

import BaseInternalFrame.BasePresentador;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DIEGO
 */
public class Presentador extends BasePresentador<Interface.vista> implements Interface.presenter{
   
    public Presentador(Interface.vista vista){
        super(vista);
    }
    
    @Override
    public void registrarProveedor(String nombre, String telefono, String direccion){
       
        if (nombre.equals("") || telefono.equals("")|| direccion.equals("")){
            vista.showMensaje("Debe llenar todos los campos \n","AVISO!");
        }else {
            try {
                adminDataBase.crearNuevoProveedor(nombre, direccion, telefono);
                vista.showMensaje("Los valores han sido agregados a la base de datos ","AVISO!");
            } catch (SQLException ex) {
                System.out.println("Error al agregar el proveedor");
                Logger.getLogger(RegistrarProveedor.class.getName()).log(Level.SEVERE, null, ex);
            }
//            finally {
//                adminDataBase.close();
//            }
            vista.showMensaje("Registro exitoso!","AVISO!");
        }

    }
}
