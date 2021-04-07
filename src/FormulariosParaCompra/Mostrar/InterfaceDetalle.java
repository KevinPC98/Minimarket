
package FormulariosParaCompra.Mostrar;

import BaseInternalFrame.BaseInterface;

/**
 *
 * @author DIEGO
 */
public interface InterfaceDetalle {
    interface vistaDetalle extends BaseInterface.BVista{
        void mostrarTabla(String cuerpo[][]);
    }
    interface presentadorDetalle extends BaseInterface.BPresenter{
        void buscarDatos();
    }
}
