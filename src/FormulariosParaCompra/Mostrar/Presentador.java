/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FormulariosParaCompra.Mostrar;

import BaseInternalFrame.BasePresentador;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;

/**
 *
 * @author Lenovo
 */
public class Presentador extends BasePresentador<Interface.vista> implements Interface.presentador{
    
    public Presentador(Interface.vista vista) {
        super(vista);
    }

    @Override
    
    public void buscarDatos(){
        Object cuerpo[][];
        int i=0, j=0,k=0;
        try {
            ResultSet rs = adminDataBase.getCompra();
            rs.last();
            i = rs.getRow();
            cuerpo = new Object[i][7];
            if(rs.first())
                do{
                    cuerpo[j][0]= rs.getString("idcompra");
                    cuerpo[j][1]= rs.getString("idempleado");
                    cuerpo[j][2]= rs.getString("idcliente");
                    cuerpo[j][3]= rs.getString("fechac");
                    cuerpo[j][4]= rs.getString("horac");
                    cuerpo[j][5]= rs.getString("montoTotal");
                    cuerpo[j][6]= new JButton("verDetalle");
                    System.out.println(cuerpo[j][0]+" | "+cuerpo[j][1]
                            +" | "+cuerpo[j][2]+" | "+cuerpo[j][3]
                            +" | "+cuerpo[j][4]+" | "+cuerpo[j][5]);
                    j++;
                } while (rs.next());
            
            vista.mostrarTabla(cuerpo);
        } catch (SQLException ex) {
            Logger.getLogger(frmMostrarCompra.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
