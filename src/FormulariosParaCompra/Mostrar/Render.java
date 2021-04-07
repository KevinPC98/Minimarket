
package FormulariosParaCompra.Mostrar;

import java.awt.Component;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;


public class Render extends DefaultTableCellRenderer{

    @Override
    public Component getTableCellRendererComponent(JTable jtable, Object value, boolean bln, boolean bln1, int i, int i1) {
        
        if(value instanceof JButton){
            JButton btn = (JButton)value;
            return btn;
        }
        
        
        return super.getTableCellRendererComponent(jtable, value, bln, bln1, i, i1); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
