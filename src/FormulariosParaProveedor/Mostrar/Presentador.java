/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FormulariosParaProveedor.Mostrar;

import BaseInternalFrame.BasePresentador;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lenovo
 */
public class Presentador extends BasePresentador<Interface.vista> implements Interface.presentador{
    
    public Presentador(Interface.vista vista) {
        super(vista);
    }

    @Override
    public void buscarDatos() {
        String cuerpo[][];
        int i=0, j=0;
        try {
            ResultSet rs = adminDataBase.getProveedor();
            rs.last();
            i = rs.getRow();
            cuerpo = new String [i][4];
            
            if(rs.first())
                do{
                    cuerpo[j][0] = Integer.toString( rs.getInt("idproveedor"));
                    cuerpo[j][1]= rs.getString("nombre");
                    cuerpo[j][2]= rs.getString("direccion");
                    cuerpo[j][3]= rs.getString("telefono");
                    System.out.println(cuerpo[j][0]+" | "+cuerpo[j][1]+" | "+cuerpo[j][2]+" | "+cuerpo[j][3]);
                    j++;
                } while (rs.next());
            vista.mostrarTabla(cuerpo);
        } catch (SQLException ex) {
            Logger.getLogger(frmMostrarProveedores.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
