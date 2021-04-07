/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FormulariosParaCompra.Mostrar;

import BaseInternalFrame.BasePresentador;
import static FormulariosParaCompra.Mostrar.frmMostrarDetalle.idcompra;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DIEGO
 */
public class PresentadorDetalle extends BasePresentador<InterfaceDetalle.vistaDetalle> implements InterfaceDetalle.presentadorDetalle{
    
    public PresentadorDetalle(InterfaceDetalle.vistaDetalle vistaDetalle) {
        super(vistaDetalle);
    }

    @Override
    public void buscarDatos(){
        String cuerpo[][];
        int i=0, j=0,k=0;
        try {
            ResultSet rs = adminDataBase.getIncluye(idcompra.getText());
            rs.last();
            i = rs.getRow();
            cuerpo = new String [i][5];
            
            if(rs.first())
                do{
                    cuerpo[j][0]= rs.getString("idcompra");
                    cuerpo[j][1]= rs.getString("nroLote");
                    cuerpo[j][2]= rs.getString("idproducto");
                    cuerpo[j][3]= rs.getString("cantidad");
                    cuerpo[j][4]= rs.getString("p_u_venta");
                    
                    System.out.println(cuerpo[j][0]+" | "+cuerpo[j][1]
                            +" | "+cuerpo[j][2]+" | "+cuerpo[j][3]
                            +" | "+cuerpo[j][4]);
                    j++;
                } while (rs.next());
            
            vista.mostrarTabla(cuerpo);
        } catch (SQLException ex) {
            Logger.getLogger(frmMostrarDetalle.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
