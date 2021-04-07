
package FormulariosParaCliente.Actualizar;

import BaseInternalFrame.BaseInterface;
import FormularioParaCliente.Model;


public interface Interface {
    interface presenter extends BaseInterface.BPresenter{
        void buscar(Model model);
        void actualizar(Model model);
    }
    interface vista extends BaseInterface.BVista{
        void mostrarResultadosDeBusqueda(String nombre,String apellidoP,String apellidoM, String direccion, String telefono,String dni);
    }
}
