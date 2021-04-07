/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FormulariosParaProveedor.Actualizar;

import FormulariosParaProveedor.Model;
import BaseInternalFrame.BasePresentador;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Lenovo
 */
public class Presenter extends BasePresentador<Interface.vista>implements Interface.presenter{
 
    public Presenter(Interface.vista vista) {
        super(vista);
    }

    @Override
    public void buscar(Model model) {
        ResultSet rs = null;
        if(model.getIdProveedor() == null){
            vista.showMensaje("La accion fue cancelada","AVISO!");
            return;
        }
        if (model.getIdProveedor().equals("")) {
            vista.showMensaje("Favor de ingresar el ID de proveedor\nque desea consultar","AVISO!");
            return;
        }
        try { 
            rs = adminDataBase.getProveedor(model.getIdProveedor()); 
            int i=1; 
            if ( rs.next()) { 
                String nombre = rs.getString("nombre");
                String direccion = rs.getString("direccion"); 
                String telefono = rs.getString("telefono");
                vista.showMensaje("Sitio Web "+ (i++) + ":\n" 
                        + nombre + "\n" 
                        + direccion + "\n" 
                        + telefono + "\n\n" ); 
                vista.mostrarResultadosDeBusqueda(nombre, direccion, telefono);
            } 
        }catch( SQLException ex ) { 
            ex.printStackTrace(); 
        }    
    }
    
    @Override
    public void actualizar(Model model){
        if (!model.esValido()) {
            vista.showMensaje("Actualice el dato deseado en el campo correspondiente","AVISO!");
        }else {
            try { 
                adminDataBase.actualizarProveedor(model); 
                vista.showMensaje("Los valores han sido Actualizados"); 
            }catch( SQLException e ) { 
                e.printStackTrace();
            }
            
            vista.showMensaje("Actualizado correctamente!","AVISO!");
        } 
    }
}
