/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FormAcceso;

import BaseJFrame.SBasePresenter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lenovo
 */
public class Presentador extends SBasePresenter<Interface.vista> implements Interface.presenter{
    
    public Presentador(Interface.vista vista){
        super(vista);
    }
    public void f(){
        
    };
    public void ingresar(String dni, String password){
        int idEmpleado = 0;
        String contrasenia = null;
        int usuario = Integer.parseInt(dni);   
        try {
            ResultSet rs = adminDataBase.getUser(dni, password);
            if (rs.next()){
                vista.showMensaje("ingreso");
                vista.irAFormularioPrincipal(dni);
                vista.salir();
            }else{
                vista.showMensaje("Error datos erróneos, Ingrese datos de nuevo");
            }
        }   catch (SQLException ex) {
                System.out.println(ex.getMessage());
            Logger.getLogger(frmAcceso.class.getName()).log(Level.SEVERE,null, ex);
        }
        vista.limpiar();
    }
}
