/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FormulariosParaCliente.Registrar;

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
        void registrarCliente(String nombre,String apellidoP,String apellidoM, String direccion, String telefono,String dni);
    }
}
