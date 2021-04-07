/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FormularioParaEmpleado;

import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Lenovo
 */
public class Model {
    private JTextField nombre;
    private JTextField apellidoP;
    private JTextField apellidoM;
    private JTextField direccion;
    private JTextField telefono;
    private JTextField dni;
    private int idSucursal;
    private int idCargo;
    private JPasswordField contra;
    private String idEmpleado;
    public Model(JTextField nombre,JTextField apellidoP,JTextField apellidoM,JTextField direccion, 
            JTextField telefono,JTextField dni, int idSucursal, int idCargo, JPasswordField contra) {
        this.nombre = nombre;
        this.apellidoP = apellidoP;
        this.apellidoM = apellidoM;
        this.direccion = direccion;
        this.telefono = telefono;
        this.dni = dni;
        this.idSucursal=idSucursal;
        this.idCargo=idCargo;
        this.contra= contra;
    }
    public boolean esValido(){
        return !(getNombre().equals("") || getDireccion().equals("") || getTelefono().equals(""));
    }
    public void setIdEmpleado(String idEmpleado) {
        this.idEmpleado = idEmpleado;
    }
    public void actualizarDatos(String nombre, String apellidoP,String apellidoM,String direccion,
                String telefono,String dni,int idSucursal,int idCargo){
        
        this.nombre.setText(nombre);
        this.apellidoP.setText(apellidoP);
        this.apellidoM.setText(apellidoM);
        this.direccion.setText(direccion);
        this.telefono.setText(telefono);
        this.dni.setText(dni);
        this.idSucursal=idSucursal;
        this.idCargo=idCargo;
        this.contra.setText("");
    }

    public String getIdEmpleado() {
        return idEmpleado;
    }
    
    public String getNombre() {
        return nombre.getText();
    }
    
    public String getApellidoP() {
        return apellidoP.getText();
    }
    
    public String getApellidoM() {
        return apellidoM.getText();
    }

    public String getDireccion() {
        return direccion.getText();
    }

    public String getTelefono() {
        return telefono.getText();
    }
    
    public String getDni() {
        return dni.getText();
    }
    
    public int getIdSucursal() {
        return idSucursal;
    }
    
    public int getIdCargo() {
        return idCargo;
    }
    
    public String getContra() {
        return contra.getText();
    }
    
}
