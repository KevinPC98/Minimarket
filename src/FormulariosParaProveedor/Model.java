/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FormulariosParaProveedor;

import java.awt.TextField;
import javax.swing.JTextField;

/**
 *
 * @author Lenovo
 */
public class Model {
    private JTextField nombre;
    private JTextField direccion;
    private JTextField telefono;
    private String idProveedor;
    public Model(JTextField nombre, JTextField direccion, JTextField telefono) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
    }
    public boolean esValido(){
        return !(getNombre().equals("") || getDireccion().equals("") || getTelefono().equals(""));
    }
    public void setIdProveedor(String idProveedor) {
        this.idProveedor = idProveedor;
    }
    public void actualizarDatos(String nombre, String direccion, String telefono){
        this.nombre.setText(nombre);
        this.direccion.setText(direccion);
        this.telefono.setText(telefono);
    }

    public String getIdProveedor() {
        return idProveedor;
    }
    
    public String getNombre() {
        return nombre.getText();
    }

    public String getDireccion() {
        return direccion.getText();
    }

    public String getTelefono() {
        return telefono.getText();
    }
    
}
