/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BaseJFrame;

import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Lenovo
 */

public abstract class SBaseJFrame<P extends SBInterface.Presentador> extends JFrame implements  SBInterface.Vista{
    protected P presentador; 
    public SBaseJFrame(){
        presentador = crearPresenter();
    }
    
    @Override
    public void showMensaje(String mensaje){
        JOptionPane.showMessageDialog(null, mensaje);
    }
    
    @Override
    public void showError(String mensaje, String title){
        javax.swing.JOptionPane.showMessageDialog(this,mensaje, title,javax.swing.JOptionPane.INFORMATION_MESSAGE);
    }
    
    @Override
    public void salir(){
        dispose();
    }

    /**
     *
     * @return
     */
    protected abstract P crearPresenter();
}
