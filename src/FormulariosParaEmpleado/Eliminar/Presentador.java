/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FormulariosParaEmpleado.Eliminar;

import BaseInternalFrame.BasePresentador;
import FormularioParaEmpleado.Model;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lenovo
 */
public class Presentador extends BasePresentador<Interface.vista> implements Interface.presentador{
    public Presentador(Interface.vista vista) {
        super(vista);
 
    }
    
    public boolean verificarEmpleado(String idEmpleado){
        boolean valido=false;
        try {
            ResultSet rst = adminDataBase.getIdCargo(idEmpleado);
            if(rst.next()){
                valido=true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Presentador.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return valido;
    }
    
    @Override
    public void buscar(Model model){
        boolean estado=false;
        if(model.getIdEmpleado()== null){
            vista.showMensaje("La accion fue cancelada","AVISO!");
            return;
        }
        if (model.getIdEmpleado().equals("")) {
            vista.showMensaje("Favor de ingresar el ID de Empleado\nque desea consultar","AVISO!");
            return;
        }
        try {
            int idCargo=0;
            int i=1; 
            ResultSet rst = adminDataBase.getIdCargo(model.getIdEmpleado());
            if(rst.next()){
                idCargo = rst.getInt("idcargo");
                estado=true;
            }
            if(estado){
                ResultSet rs = adminDataBase.getEmpleado(model.getIdEmpleado());
                if(rs.next()) { 
                    String nombre = rs.getString("nombre");
                    String direccion = rs.getString("direccion"); 
                    String telefono = rs.getString("telefono"); 
                    String apellidoP = rs.getString("apellidoPaterno"); 
                    String apellidoM = rs.getString("apellidoMaterno"); 
                    String dni = rs.getString("dni"); 
                    int idSucursal = rs.getInt("idsucursal");
                    System.out.println(":\n" 
                                    + nombre + "\n" 
                                    + direccion + "\n" 
                                    + telefono + "\n\n" ); 
                    model.actualizarDatos(nombre,apellidoP,apellidoM,direccion,
                            telefono,dni,idSucursal,idCargo);
                }
            }else{
                vista.showMensaje("El empleado no existe o esta deshabilitado\npor favor busque de nuevo","AVISO!");
            }
        } catch( SQLException ex ) { 
        } 

    }

    @Override
    public void eliminar(Model model) {
        try {
            if(verificarEmpleado(model.getIdEmpleado())){
                adminDataBase.eliminarTieneCargo(model);
                //adminDataBase.eliminarEmpleado(model.getIdEmpleado());
                System.out.println(model.getIdEmpleado());
                vista.showMensaje("Actualizado correctamente!","AVISO!");
            }else{
                vista.showMensaje("Por favor ingrese el IdEmpleado correctamente","AVISO!");
            }
        }catch( SQLException e ) {
            System.out.println(e);
            vista.showMensaje("Por favor ingrese el IdEmpleado correctamente","AVISO!");
        }
        vista.limpiar();
    } 

    
}
