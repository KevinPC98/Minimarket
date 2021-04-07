/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FormulariosParaCliente.Actualizar;

import FormularioParaCliente.Model;
import BaseInternalFrame.BasePresentador;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lenovo
 */
public class Presenter extends BasePresentador<Interface.vista>implements Interface.presenter{
 
    public Presenter(Interface.vista vista) {
        super(vista);
    }

    public void buscar(Model model) {
        ResultSet rs = null;
        if(model.getIdCliente()== null){
            vista.showMensaje("La accion fue cancelada","AVISO!");
            return;
        }
        if (model.getIdCliente().equals("")) {
            vista.showMensaje("Favor de ingresar el ID de Cliente\nque desea consultar","AVISO!");
            return;
        }
        try { 
            rs = adminDataBase.getCliente(model.getIdCliente()); 
            int i=1; 
            if ( rs.next()) { 
                String nombre = rs.getString("nombre");
                String direccion = rs.getString("direccion"); 
                String telefono = rs.getString("telefono");
                String apellidoP = rs.getString("apellidoPaterno");
                String apellidoM = rs.getString("apellidoMaterno");
                String dni = rs.getString("dni");
                vista.showMensaje("Sitio Web "+ (i++) + ":\n" 
                        + nombre + "\n" 
                        + apellidoP + "\n" 
                        + apellidoM + "\n" 
                        + dni + "\n" 
                        + direccion + "\n" 
                        + telefono + "\n\n" ); 
                vista.mostrarResultadosDeBusqueda(nombre, apellidoP,apellidoM,direccion, telefono,dni);
            } 
        }catch( SQLException ex ) { 
            ex.printStackTrace(); 
        }    
    }
    
    public void actualizar(Model model){
        if (!model.esValido()) {
            vista.showMensaje("Actualice el dato deseado en el campo correspondiente","AVISO!");
        }else {
            try {
                adminDataBase.actualizarCliente(model);
            } catch (SQLException ex) {
                Logger.getLogger(Presenter.class.getName()).log(Level.SEVERE, null, ex);
            }
            vista.showMensaje("Los valores han sido Actualizados");
            
            vista.showMensaje("Actualizado correctamente!","AVISO!");
        } 
    }
}
