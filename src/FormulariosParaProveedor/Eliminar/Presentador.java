 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FormulariosParaProveedor.Eliminar;

import BaseInternalFrame.BasePresentador;
import FormulariosParaProveedor.Model;
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
    
    @Override
    public void buscar(Model model) {
        if(model.getIdProveedor()== null){
            vista.showMensaje("La accion fue cancelada","AVISO!");
            return;
        }
        if (model.getIdProveedor().equals("")) {
            vista.showMensaje("Favor de ingresar el ID de proveedor\nque desea consultar","AVISO!");
            return;
        }
        try { 
            ResultSet rs = adminDataBase.getProveedor(model.getIdProveedor());
            if(rs.next()) { 
                String nombre = rs.getString("nombre");
                String direccion = rs.getString("direccion"); 
                String telefono = rs.getString("telefono");
                System.out.println(":\n" 
                                + nombre + "\n" 
                                + direccion + "\n" 
                                + telefono + "\n\n" ); 
                model.actualizarDatos(nombre, direccion, telefono);
            } 
        } catch( SQLException ex ) { 
                ex.printStackTrace(); 
        } 

    }

    @Override
    public void eliminar(Model model) {
        try { 
            adminDataBase.eliminarProveedor(model.getIdProveedor());
            vista.showMensaje("Los valores han sido Actualizados"); 
        }catch( SQLException e ) { 
            e.printStackTrace(); 
        } 
//        finally { 
//            adminDataBase.close();
//        }
        vista.showMensaje("Actualizado correctamente!","AVISO!");
        vista.limpiar();
    } 
}
