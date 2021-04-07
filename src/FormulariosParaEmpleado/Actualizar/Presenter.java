/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FormulariosParaEmpleado.Actualizar;

import FormularioParaEmpleado.Model;
import BaseInternalFrame.BasePresentador;
import FormulariosParaEmpleado.Registrar.Presentador;
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
    
    public boolean verificarDni(String dni,String idempleado){
        boolean valido=false;
        try {
            ResultSet rs = adminDataBase.verificarDniDelEmpleado(dni,idempleado);
            if(rs.next()){
                valido=true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Presentador.class.getName()).log(Level.SEVERE, null, ex);
        }
        return valido;
    }
    
    @Override
    public void buscar(Model model) {
        ResultSet rs = null;
        ResultSet rst = null;
        if(model.getIdEmpleado() == null){
            vista.showMensaje("La accion fue cancelada","AVISO!");
            return;
        }
        if (model.getIdEmpleado().equals("")) {
            vista.showMensaje("Favor de ingresar el ID de Empleado\nque desea consultar","AVISO!");
            return;
        }
        try{
            int idCargo=0;
            int i=1; 
            rst = adminDataBase.getIdCargo(model.getIdEmpleado());
            if(rst.next()){
                idCargo = rst.getInt("idcargo");
            }
            rs = adminDataBase.getEmpleado(model.getIdEmpleado());
            if( rs.next()){ 
                String nombre = rs.getString("nombre");
                String direccion = rs.getString("direccion"); 
                String telefono = rs.getString("telefono"); 
                String apellidoP = rs.getString("apellidoPaterno"); 
                String apellidoM = rs.getString("apellidoMaterno"); 
                String dni = rs.getString("dni"); 
                int idSucursal = rs.getInt("idsucursal");
                vista.showMensaje("Sitio Web "+ (i++) + ":\n" 
                        + nombre + "\n" 
                        + direccion + "\n" 
                        + telefono + "\n\n" ); 
                vista.mostrarResultadosDeBusqueda(nombre,apellidoP,apellidoM,direccion,
                        telefono,dni,idSucursal,idCargo);
            } 
        }catch( SQLException ex ) { 
            ex.printStackTrace(); 
        }    
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
    
    @Override
    public void actualizar(Model model){
        if (!model.esValido()){
            vista.showMensaje("Actualice el dato deseado en el campo correspondiente","AVISO!");
        }else {
            try {
                if(verificarDni(model.getDni(),model.getIdEmpleado())){
                    adminDataBase.actualizarEstadoCargo(model);
                    adminDataBase.actualizarEmpleado(model);
                    agregarTieneCargo(model.getDni(),model.getIdCargo());
                    vista.showMensaje("Los valores han sido Actualizados");
                }else{
                    vista.showMensaje("DNI Invalido");
                }
            }catch( SQLException e ) { 
                e.printStackTrace();
            }
        } 
    }
}
