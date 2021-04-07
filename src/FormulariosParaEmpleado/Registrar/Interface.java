/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FormulariosParaEmpleado.Registrar;

import BaseInternalFrame.BaseInterface;

/**
 *
 * @author DIEGO
 */
public interface Interface {
    interface vista extends BaseInterface.BVista{
        
    }
    interface presenter extends BaseInternalFrame.BaseInterface.BPresenter{
        void registrarEmpleado(String apeM, String apeP, 
            String contra, String direccion, String dni, String nombre,
            String telefono, int idsucursal, int cargo);
    }
}
