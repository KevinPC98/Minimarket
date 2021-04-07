/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FormularioParaCliente;

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
    private String idCliente;
    public Model(JTextField nombre,JTextField apellidoP,JTextField apellidoM, JTextField direccion, JTextField telefono,JTextField dni) {
        this.nombre = nombre;
        this.apellidoP = apellidoP;
        this.apellidoM = apellidoM;
        this.direccion = direccion;
        this.telefono = telefono;
        this.dni = dni;
    }
    public boolean esValido(){
        return !(getNombre().equals("") || getDireccion().equals("") || getTelefono().equals("") 
                || getApellidoM().equals("")||getApellidoP().equals("")||getDni().equals(""));
    }
    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }
    public void actualizarDatos(String nombre,String apellidoP,String apellidoM, String direccion, String telefono,String dni){
        this.nombre.setText(nombre);
        this.apellidoP.setText(apellidoP);
        this.apellidoM.setText(apellidoM);
        this.direccion.setText(direccion);
        this.telefono.setText(telefono);
        this.dni.setText(dni);
    }

    public String getIdCliente() {
        return idCliente;
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
    
}
