/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frmPrincipal;
import BaseJFrame.SBasePresenter;
import java.awt.Point;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;

/**
 *
 * @author Lenovo
 */
public class Presentador extends SBasePresenter<Interface.Vista> implements Interface.Presentador{
    
    public Presentador(Interface.Vista vista) {
        super(vista);
    }

    @Override
    public Point getPosicion(JDesktopPane jPane, JInternalFrame frame) {
        int x = (jPane.getWidth() - frame.getWidth())/2;
        int y  =(jPane.getHeight()- frame.getHeight())/2;
        return new Point(x, y);
    }
    
}
