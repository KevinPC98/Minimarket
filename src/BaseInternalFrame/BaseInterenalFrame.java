/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BaseInternalFrame;

import javax.swing.JOptionPane;

/**
 *
 * @author KevinPC
 * @param <P>
 */
public abstract  class BaseInterenalFrame<P> extends javax.swing.JInternalFrame implements BaseInterface.BVista{
    protected P presentador;
    
    public BaseInterenalFrame(){
        presentador = crearPresentador();
    }
    /**
     *
     * @return
     */
    public void salir(){
        dispose();
    }
    
    @Override
    public void showMensaje(String mensaje){
        JOptionPane.showMessageDialog(null, mensaje);
    }
    @Override
    public void showMensaje(String mensaje, String title){
        javax.swing.JOptionPane.showMessageDialog(this,mensaje, title,javax.swing.JOptionPane.INFORMATION_MESSAGE);
    }
    protected abstract P crearPresentador();
}
