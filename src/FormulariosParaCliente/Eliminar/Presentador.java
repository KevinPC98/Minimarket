/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FormulariosParaCliente.Eliminar;

import BaseDeDatos.AdminDataBase;
import BaseInternalFrame.BasePresentador;
import FormularioParaCliente.Model;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Lenovo
 */
public class Presentador extends BasePresentador<Interface.vista> implements Interface.presentador{
    public Presentador(Interface.vista vista) {
        super(vista);
 
    }
    
    public void buscar(Model model) {
        if(model.getIdCliente()== null){
            vista.showMensaje("La accion fue cancelada","AVISO!");
            return;
        }
        if (model.getIdCliente().equals("")) {
            vista.showMensaje("Favor de ingresar el ID de Cliente\nque desea consultar","AVISO!");
            return;
        }
        try { 
            ResultSet rs = adminDataBase.getCliente(model.getIdCliente());
            if(rs.next()) { 
                String nombre = rs.getString("nombre");
                String direccion = rs.getString("direccion"); 
                String telefono = rs.getString("telefono");
                String apellidoP = rs.getString("apellidoPaterno");
                String apellidoM = rs.getString("apellidoMaterno");
                String dni = rs.getString("dni");
                System.out.println(":\n" 
                                + nombre + "\n" 
                                + direccion + "\n" 
                                + telefono + "\n\n" ); 
                model.actualizarDatos(nombre, apellidoP,apellidoM,direccion, telefono,dni);
            } 
        } catch( SQLException ex ) { 
        } 

    }

    public void eliminar(Model model) {
        try { 
            adminDataBase.eliminarCliente(model.getIdCliente());
            vista.showMensaje("Los valores han sido Actualizados"); 
        }catch( SQLException e ) { 
        }
        vista.showMensaje("Actualizado correctamente!","AVISO!");
        vista.limpiar();
    } 

    
}
