/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FormulariosParaProveedor.Registrar;

import BaseInternalFrame.BaseInterface;

/**
 *
 * @author DIEGO
 */
public interface Interface {
    interface vista extends BaseInterface.BVista{
    }
    interface presenter extends BaseInternalFrame.BaseInterface.BPresenter{

        /**
         *
         * @param nombre
         * @param telefono
         * @param direccion
         */
        void registrarProveedor(String nombre, String telefono, String direccion);
    }
}
