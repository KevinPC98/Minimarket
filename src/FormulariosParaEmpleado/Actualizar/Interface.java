/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FormulariosParaEmpleado.Actualizar;

import BaseInternalFrame.BaseInterface;
import FormularioParaEmpleado.Model;

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
        void mostrarResultadosDeBusqueda(String nombre, String apellidoP,String apellidoM,String direccion,
                String telefono,String dni,int idSucursal,int idCargo);
    }
}
