/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FormulariosParaEmpleado.Eliminar;

import BaseInternalFrame.BaseInterface;
import FormularioParaEmpleado.Model;

/**
 *
 * @author Lenovo
 */
public interface Interface {
    interface vista extends BaseInterface.BVista{
    }
    interface presentador extends BaseInterface.BPresenter{
        void buscar(Model model);
        void eliminar(Model model);
    }
}
