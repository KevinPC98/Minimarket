/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FormulariosParaCompra.Mostrar;

import BaseInternalFrame.BaseInterface;

/**
 *
 * @author Lenovo
 */
public interface Interface {
    interface vista extends BaseInterface.BVista{
        void mostrarTabla(Object cuerpo[][]);
    }
    interface presentador extends BaseInterface.BPresenter{
        void buscarDatos();
    }
}
