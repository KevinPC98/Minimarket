/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FormAcceso;

import BaseJFrame.SBInterface;
import BaseInternalFrame.BaseInterface;

/**
 *
 * @author Lenovo
 */
public interface Interface {
    interface vista extends SBInterface.Vista{

        /**
         *
         * @param idEmpleado
         */
        void irAFormularioPrincipal(String idEmpleado);
    }
    interface presenter extends SBInterface.Presentador{
        void ingresar(String user, String password);
    }
}
