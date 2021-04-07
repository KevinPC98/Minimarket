/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FormulariosParaEmpleado.Mostrar;

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
            ResultSet rs = adminDataBase.getEmpleado();
            rs.last();
            i = rs.getRow();
            cuerpo = new String [i][9];
            
            if(rs.first())
                do{
                    cuerpo[j][0] = Integer.toString( rs.getInt("idempleado"));
                    cuerpo[j][1]= rs.getString("nombre");
                    cuerpo[j][2]= rs.getString("apellidoPaterno");
                    cuerpo[j][3]= rs.getString("apellidoMaterno");
                    cuerpo[j][4]= rs.getString("direccion");
                    cuerpo[j][5]= rs.getString("telefono");
                    cuerpo[j][6]= rs.getString("dni");
                    if(adminDataBase.getCargo(rs.getString("idempleado")) == null){
                        cuerpo[j][7]="INHABILITADO";
                    }else{
                        cuerpo[j][7]= adminDataBase.getCargo(rs.getString("idempleado"));
                    }
                    cuerpo[j][8]= adminDataBase.getNombreSucursal(rs.getString("idsucursal"));
                    System.out.println(cuerpo[j][0]+" | "+cuerpo[j][1]
                            +" | "+cuerpo[j][2]+" | "+cuerpo[j][3]
                            +" | "+cuerpo[j][4]+" | "+cuerpo[j][5]+" | "+cuerpo[j][6]
                            +" | "+cuerpo[j][7]+" | "+cuerpo[j][8]);
                    j++;
                } while (rs.next());
            
            vista.mostrarTabla(cuerpo);
        } catch (SQLException ex) {
            Logger.getLogger(frmMostrarEmpleados.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
