/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FormulariosParaEmpleado.Registrar;

import BaseInternalFrame.BasePresentador;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DIEGO
 */
public class Presentador extends BasePresentador<Interface.vista> implements Interface.presenter{
    public Presentador(Interface.vista v){
        super(v);
    }
    
    public void agregarTieneCargo(String dni, int cargo){
        ResultSet rs=null;
        try {
            String idEmpleado;
            rs = adminDataBase.buscarIdEmpleado(dni);
            if ( rs.next()) {
                idEmpleado= rs.getString("idempleado");
                adminDataBase.agregarCargo(idEmpleado, cargo);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Presentador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public boolean verificarDni(String dni){
        boolean valido=true;
        try {
            ResultSet rs = adminDataBase.verificarDni(dni);
            if(rs.next()){
                valido=false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Presentador.class.getName()).log(Level.SEVERE, null, ex);
        }
        return valido;
    }
    
    @Override
    public void registrarEmpleado(String apeM, String apeP, 
            String contra, String direccion, String dni, String nombre,
            String telefono, int idsucursal, int cargo){
         
        if ((nombre.equals("")) || (telefono.equals(""))|| (direccion.equals(""))){
            vista.showMensaje("Debe llenar todos los campos \n","AVISO!");
        }
        else {
            try {
                if(verificarDni(dni)){
                    System.out.println("Los valores han sido agregados a la base de datos ");
                    adminDataBase.crearNuevoEmpleado(idsucursal, nombre, contra, apeP, apeM, direccion, telefono, dni);
                    agregarTieneCargo(dni,cargo);
                    vista.showMensaje("Registro exitoso!","AVISO!");
                }else{
                    vista.showMensaje("DNI INVALIDO","AVISO!");
                }
            } catch (SQLException ex) {
                Logger.getLogger(RegistrarEmpleado.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    
}
