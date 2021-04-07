
package BaseDeDatos;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
public class AdminDataBase {
    private Statement statement;
    private Connection connection;
        
    public AdminDataBase(){
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String connectionURL ="jdbc:sqlserver://DECK:1433;databaseName=Minimarket;user=usuarioSQL;password=123;";
            connection = DriverManager.getConnection(connectionURL);
            System.out.println("Nos Conectamos");
            if ( connection != null )
            System.out.println("Se ha establecido una conexión a la base de datos " +
                "\n " + connectionURL );
        } 
        catch (Exception e) {
            System.out.println("ERROR"+e.getMessage());
        }
    }
    
    public void close(){
        try {
            if (connection != null) {
                connection.close();
            }
            if(statement  != null){
                statement.close();
            }
        } catch (SQLException ex) {
                Logger.getLogger(AdminDataBase.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    }
    
    public ResultSet getUser(Object usuario, Object password) throws SQLException{
        Statement st = connection.createStatement();
        return st.executeQuery("SELECT e.idempleado, dni, t.idcargo, t.estado FROM   empleado as e, tiene as t WHERE e.idempleado=t.idempleado \n" +
"			and t.estado=1 and dni="+usuario+"and contrasenia  = (HASHBYTES('SHA2_256', '"+password+"'))");
    }
    
    public int crearNuevoEmpleado(int idsucursal, String nombre, String contra, String apeP, String apeM, String direccion, String telefono, String dni) throws SQLException{
        Statement st = connection.createStatement();
        return st.executeUpdate("INSERT INTO empleado VALUES("+idsucursal+",'"+
                    nombre+"',HASHBYTES('SHA2_256','"+contra+"'),'"+apeP+"','"+apeM+"','"+direccion+"','"+
                    telefono+"','"+dni+"')");  
    }
    
    public int crearNuevoProveedor(String nombre, String direccion, String telefono) throws SQLException{
        Statement st = connection.createStatement();
        return st.executeUpdate("INSERT INTO proveedor VALUES('"+
                    nombre+"', '"+direccion+"','"+telefono+"')");
    }
    public ResultSet getProveedor(Object idProveedor)throws SQLException{
        
        Statement st = connection.createStatement();
        return st.executeQuery("Select * FROM proveedor where idproveedor = '"+idProveedor+"'");
    }
    public ResultSet getProveedor()throws SQLException{
        Statement st = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        return st.executeQuery("Select * FROM proveedor");
    }
    
    public int actualizarProveedor(FormulariosParaProveedor.Model model)throws SQLException{
        Statement st = connection.createStatement();
        return st.executeUpdate("update proveedor set nombre = '"+model.getNombre()+
                                                            "',direccion = '"+model.getDireccion()+
                                                            "',telefono = '"+model.getTelefono()+
                                        "' where idproveedor = '"+model.getIdProveedor()+"' ");  
    }
    
    public int eliminarProveedor(Object idProveedor)throws SQLException{
        Statement st = connection.createStatement();
        return st.executeUpdate("delete from proveedor where idproveedor = '"+idProveedor+"'" );
    }
    
    public int crearNuevoCliente(String nombre,String apellidoP,String apellidoM, String direccion, String telefono,String dni) throws SQLException{
        Statement st = connection.createStatement();
        return st.executeUpdate("INSERT INTO cliente VALUES('"+
                    nombre+"', '"+apellidoP+"','"+apellidoM+"','"+direccion+"','"+telefono+"','"+dni+"')");
    }
    
    public ResultSet getCliente(Object idCliente)throws SQLException{
        
        Statement st = connection.createStatement();
        return st.executeQuery("Select * FROM cliente where idcliente = '"+idCliente+"'");
    }
    
    public int actualizarCliente(FormularioParaCliente.Model model)throws SQLException{
        Statement st = connection.createStatement();
        return st.executeUpdate("update cliente set nombre = '"+model.getNombre()+
                                                            "',direccion = '"+model.getDireccion()+
                                                            "',telefono = '"+model.getTelefono()+
                                                            "',apellidoPaterno = '"+model.getApellidoP()+
                                                            "',apellidoMaterno = '"+model.getApellidoM()+
                                                            "',dni = '"+model.getDni()+
                                        "' where idcliente = '"+model.getIdCliente()+"' ");  
    }
    
    public int eliminarCliente(Object idCliente)throws SQLException{
        Statement st = connection.createStatement();
        return st.executeUpdate("delete from cliente where idcliente = '"+idCliente+"'" );
    }
    
    public ResultSet getCliente()throws SQLException{
        Statement st = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        return st.executeQuery("Select * FROM cliente");
    }
    
    public ResultSet buscarIdEmpleado(String dni)throws SQLException{
        Statement stm = connection.createStatement();
        return stm.executeQuery("select * from empleado where dni = '"+dni+"'" );
    }
    
    public int agregarCargo(String idEmpleado,int idCargo) throws SQLException{
        Statement stmt = connection.createStatement();
        return stmt.executeUpdate("INSERT INTO tiene VALUES("+idEmpleado+","+
                    idCargo+","+1+",CONVERT (date, SYSDATETIME()), CONVERT (time, SYSDATETIME()))");
    }
    
    public ResultSet getEmpleado(Object idEmpleado)throws SQLException{
        Statement st = connection.createStatement();
        return st.executeQuery("Select * FROM empleado where idempleado = '"+idEmpleado+"'");
    }
    
    public ResultSet getIdCargo(Object idEmpleado)throws SQLException{
        Statement st = connection.createStatement();
        return st.executeQuery("Select * FROM tiene where idempleado = '"+idEmpleado+"'"
                + " and estado = 1 ");
    }
    
    public int actualizarEmpleado(FormularioParaEmpleado.Model model)throws SQLException{
        Statement st = connection.createStatement();
        
        if(model.getContra().equals("")){
            return st.executeUpdate("update empleado set idsucursal= '"+model.getIdSucursal()+
                                "',nombre = '"+model.getNombre()+
                                "',apellidoPaterno = '"+model.getApellidoP()+
                                "',apellidoMaterno = '"+model.getApellidoM()+
                                "',direccion = '"+model.getDireccion()+
                                "',telefono = '"+model.getTelefono()+
                                "',dni = '"+model.getDni()+
                                "' where idempleado = '"+model.getIdEmpleado()+"' ");  
        }else{
            return st.executeUpdate("update empleado set idsucursal= '"+model.getIdSucursal()+
                                "',nombre = '"+model.getNombre()+
                                "',contrasenia = HASHBYTES('SHA2_256','"+model.getContra()+"')"+
                                ",apellidoPaterno = '"+model.getApellidoP()+
                                "',apellidoMaterno = '"+model.getApellidoM()+
                                "',direccion = '"+model.getDireccion()+
                                "',telefono = '"+model.getTelefono()+
                                "',dni = '"+model.getDni()+
                                "' where idempleado = '"+model.getIdEmpleado()+"' ");  
        }
    }
    
    public int actualizarEstadoCargo(FormularioParaEmpleado.Model model)throws SQLException{
        Statement st = connection.createStatement();
        return st.executeUpdate("update tiene set estado= 0"+
                                " where idempleado = '"+model.getIdEmpleado()+"' ");  
    }
    
    public int actualizarTieneCargo(FormularioParaEmpleado.Model model)throws SQLException{
        Statement st = connection.createStatement();
        
        return st.executeUpdate("update tiene set estado= 1"+
                                " where idempleado = '"+model.getIdEmpleado()+
                                "' and idcargo = '"+model.getIdCargo()+"' " );  
    }
    
    public int eliminarTieneCargo(FormularioParaEmpleado.Model model)throws SQLException{
        Statement st = connection.createStatement();
        return st.executeUpdate("update tiene set estado=0 where idempleado = '"+model.getIdEmpleado()+"'" );
    }
    
    public int eliminarEmpleado(Object idEmpleado)throws SQLException{
        Statement st = connection.createStatement();
        return st.executeUpdate("delete from empleado where idempleado = '"+idEmpleado+"'" );
    }
    
    public ResultSet getEmpleado()throws SQLException{
        Statement st = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        return st.executeQuery("Select * FROM empleado");
    }
    
    public String getCargo(String idEmpleado)throws SQLException{
        Statement st = connection.createStatement();
        Statement stm = connection.createStatement();
        String nombreCargo=null;
        ResultSet rs =st.executeQuery("Select idcargo FROM tiene where idempleado='"+idEmpleado+"' and estado = 1");
        ResultSet rst=null;
        if(rs.next()){
            System.out.println(rs.getString("idcargo"));
            rst = stm.executeQuery("Select nombreCargo FROM cargo where idcargo='"+rs.getString("idcargo")+"'");
            if(rst.next()){
                System.out.println(rst.getString("nombreCargo"));
                nombreCargo = rst.getString("nombreCargo");
            }
        }
        return nombreCargo;
    }
    
    public String getNombreSucursal(String idSucursal)throws SQLException{
        Statement st = connection.createStatement();
        String nombreSucursal=null;
        ResultSet rs =st.executeQuery("Select nombre FROM sucursal where idsucursal='"+idSucursal+"'");
        if(rs.next()){
            nombreSucursal = rs.getString("nombre");
        }
        return nombreSucursal;
    }
    
    public ResultSet getProducto(Object idProducto)throws SQLException{
        Statement st = connection.createStatement();
        return st.executeQuery("Select * FROM producto where idproducto = '"+idProducto+"'");
    }
    
    public int crearNuevoProducto(int idProducto, String nombre, String descripcion) throws SQLException{
        Statement st = connection.createStatement();
        return st.executeUpdate("INSERT INTO producto VALUES('"+idProducto+"','"+nombre+"','"+
                              descripcion+"')");
    }
    
    public int crearNuevoContieneProducto(int idProductoGlobal, int idProductoContiene) throws SQLException{
        Statement st = connection.createStatement();
        return st.executeUpdate("INSERT INTO contiene VALUES('"+idProductoGlobal+"','"+idProductoContiene+"')");
    }
    
    public int crearNuevoLote(int nroLote,String fechaEntrega, String fechaVencimiento ,int idProveedor) throws SQLException{
        Statement st = connection.createStatement();
        return st.executeUpdate("INSERT INTO lote VALUES('"+nroLote+"','"+fechaEntrega+"','"+
                              fechaVencimiento+"','"+idProveedor+"')");
    }
    
    public int crearPertenece(int nroLote,int idProducto, int cantidadLote ,int stock, float precioUnitarioVenta, float precioUnitarioCompra) throws SQLException{
        Statement st = connection.createStatement();
        return st.executeUpdate("INSERT INTO pertenece VALUES('"+nroLote+"','"+idProducto+"','"+
                              cantidadLote+"','"+stock+"','"+precioUnitarioVenta+"','"+precioUnitarioCompra+"')");
    }
    
    public ResultSet getLote(Object nroLote)throws SQLException{
        
        Statement st = connection.createStatement();
        return st.executeQuery("Select * FROM lote where nrolote = '"+nroLote+"'");
    }
    
    public int crearNuevaCompra(float montoTotal,int idEmpleado,int idCliente) throws SQLException{
        Statement st = connection.createStatement();
        return st.executeUpdate("INSERT INTO compra VALUES(CONVERT (date, SYSDATETIME()),CONVERT (time, SYSDATETIME()),'"+montoTotal+"','"+idEmpleado+"','"+idCliente+"')");
    }
    
    public int ultimaCompra()throws SQLException{
        Statement st = connection.createStatement();
        int idCompra=0;
        ResultSet rs =st.executeQuery("Select * FROM compra");
        while(rs.next()){
            idCompra = rs.getInt("idcompra");
        }
        return idCompra;
    }
    
    public int crearComprobante(int idCompra,String comprobante) throws SQLException{
        Statement st = connection.createStatement();
        return st.executeUpdate("INSERT INTO comprobante VALUES("+idCompra+",'"+comprobante+"')");
    }
    
    public int crearNuevoIncluye(int idCompra,int idProducto,int nroLote,int cantidad, float precioVenta) throws SQLException{
        Statement st = connection.createStatement();
        return st.executeUpdate("INSERT INTO incluye VALUES('"+idCompra+"','"+idProducto+"','"+nroLote+"','"+cantidad+"','"+precioVenta+"')");
    }
    
    public int actualizarPertenece(int nroLote,int idProducto, int cantidadLote) throws SQLException{
        Statement st = connection.createStatement();
        return st.executeUpdate("UPDATE pertenece SET stock=stock-'"+cantidadLote+"' WHERE pertenece.nrolote='"+nroLote+"' and pertenece.idproducto='"+idProducto+"'");
    }
    
    public ResultSet getPertenece()throws SQLException{
        Statement st = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        return st.executeQuery("Select * FROM pertenece");
    }
    
    public ResultSet getCompra()throws SQLException{
        Statement st = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        return st.executeQuery("Select * FROM compra");
    }
    
    public ResultSet getIncluye(String idcompra)throws SQLException{
        Statement st = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        return st.executeQuery("Select * FROM incluye where idcompra ='"+idcompra+"'");
    }
    
    public ResultSet verificarDni(String dni)throws SQLException{
        Statement st = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        return st.executeQuery("Select * FROM empleado where dni='"+dni+"'");
    }
    
    public ResultSet verificarDniDelEmpleado(String dni,String idempleado)throws SQLException{
        Statement st = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        return st.executeQuery("Select * FROM empleado where dni='"+dni+"' and idempleado='"+idempleado+"'");
    }
}
