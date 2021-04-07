/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FormulariosParaProveedor.Actualizar;

import BaseInternalFrame.BaseInterface;
import FormulariosParaProveedor.Model;

/**
 *
 * @author Lenovo
 */
public interface Interface {
    interface presenter extends BaseInterface.BPresenter{
        void buscar(Model model);
        void actualizar(Model model);
    }
    interface vista extends BaseInterface.BVista{
        void mostrarResultadosDeBusqueda(String nombre, String direccion, String telefono);
    }
}
