/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FormulariosParaProducto.Mostrar;

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
        int i=0, j=0,k=0;
        try {
            ResultSet rs = adminDataBase.getPertenece();
            rs.last();
            i = rs.getRow();
            cuerpo = new String [i][7];
            
            if(rs.first())
                do{
                    cuerpo[j][0] = Integer.toString( rs.getInt("idproducto"));
                    ResultSet rst = adminDataBase.getProducto(rs.getInt("idproducto"));
                    if(rst.next()){
                        cuerpo[j][1]= rst.getString("nombre");
                        cuerpo[j][2]= rst.getString("descripcion");
                    }
                    ResultSet rst1 =adminDataBase.getLote(rs.getInt("nrolote"));
                    if(rst1.next()){
                        cuerpo[j][3]= Integer.toString( rst1.getInt("nroLote"));
                        cuerpo[j][4]= rst1.getString("fechavencimiento");
                    }
                    cuerpo[j][5]= rs.getString("cantidadLote");
                    cuerpo[j][6]= rs.getString("stock");
                    
                    System.out.println(cuerpo[j][0]+" | "+cuerpo[j][1]
                            +" | "+cuerpo[j][2]+" | "+cuerpo[j][3]
                            +" | "+cuerpo[j][4]+" | "+cuerpo[j][5]+" | "+cuerpo[j][6]);
                    j++;
                } while (rs.next());
            
            vista.mostrarTabla(cuerpo);
        } catch (SQLException ex) {
            Logger.getLogger(frmMostrarProductos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
