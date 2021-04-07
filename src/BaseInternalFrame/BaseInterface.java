/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BaseInternalFrame;

/**
 *
 * @author KevinPC
 */
public interface BaseInterface {
    interface BPresenter{
        
    }
    interface BVista{
        void limpiar();
        void showMensaje(String mensaje);
        void showMensaje(String mensaje, String title);
        void salir();
    }
}
