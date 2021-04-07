/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BaseJFrame;

/**
 *
 * @author Lenovo
 */
public interface SBInterface {
    interface Presentador{
        
    }
    interface Vista{
        void limpiar();
        void showMensaje(String Mensaje);
        void showError(String Mensaje, String titulo);
        void salir();
    }
}
