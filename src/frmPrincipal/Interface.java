/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frmPrincipal;

import BaseJFrame.SBInterface;
import java.awt.Point;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;


/**
 *
 * @author Lenovo
 */
public interface Interface {
    interface Vista extends SBInterface.Vista{
        
    }
    interface Presentador extends SBInterface.Presentador{
        Point getPosicion(JDesktopPane desktopPane, JInternalFrame frame);
    }
}
