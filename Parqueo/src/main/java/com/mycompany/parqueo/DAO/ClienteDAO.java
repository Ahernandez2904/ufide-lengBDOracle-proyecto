package com.mycompany.parqueo.DAO;

import com.mycompany.parqueo.Cliente;
import com.mycompany.parqueo.Conexion;
import com.mycompany.parqueo.Vehiculo;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import oracle.jdbc.OracleTypes;

/**
 * LastUpdate: 01/04/21
 *
 * @author lsalazar Description: Permite el menejo de los datos de la calse
 * cliente con la DB
 */
public class ClienteDAO extends Conexion {

    private Cliente cliente;
    private Conexion conn;

    public ClienteDAO() { }

    public Cliente usp_insCliente(Cliente cl) throws SQLException {
        this.cliente = cl;
        String sqlString = "{call usp_insCliente (?,?,?,?,?,?,?,?)}";
        conn = new Conexion();
        
        try {
            conn.openConn();
            CallableStatement cstm = conn.getConn().prepareCall(sqlString);
            cstm.setString(1, cliente.getNombre());
            cstm.setString(2, cliente.getPrimer_Apellido());
            cstm.setString(3, cliente.getSegundo_Apellido());
            cstm.setString(4, cliente.getDni());
            cstm.setString(5, cliente.getDireccion());
            cstm.setInt(6, cliente.getDistrito_Id());
            //cstm.setNull(6, java.sql.Types.INTEGER);
            cstm.setInt(7, cliente.getEstado_Cliente());
            cstm.registerOutParameter(8, Types.INTEGER);
            cstm.executeUpdate();
            cliente.setCodCliente(cstm.getInt(8));
            conn.getConn().setAutoCommit (false);
            conn.getConn().commit();
            conn.getConn().close();
            return cliente;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            conn.getConn().close();
            return cliente;
        }
    }
    
    public List<Cliente> USP_selClienteXVehiculo(Vehiculo v) throws SQLException {
        List<Cliente> c_list = new ArrayList<Cliente>();
        String sqlString = "{call USP_selClienteXVehiculo (?,?)}";
        conn = new Conexion();
    
        try {
            conn.openConn();
            CallableStatement cstm = conn.getConn().prepareCall(sqlString);
            cstm.setInt(1, v.getVehiculo_Id());
            cstm.registerOutParameter(2, OracleTypes.CURSOR);
            cstm.executeUpdate();
            ResultSet rs = (ResultSet) cstm.getObject(2);
            while (rs.next()) {
                cliente = new Cliente();
                cliente.setCodCliente(rs.getInt("cliente_id"));
                cliente.setNombre(rs.getString("Nombre"));
                cliente.setPrimer_Apellido(rs.getString("Primer_apellido"));
                cliente.setSegundo_Apellido(rs.getString("Segundo_apellido"));
                cliente.setDetalle_Dir_Id(rs.getInt("Detalle_dir_ID"));
                cliente.setDni(rs.getString("DNI"));
                cliente.setEstado_Cliente(rs.getInt("ESTADO_CLIENTE"));
                c_list.add(cliente);
            }
            conn.getConn().close();
            return c_list;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            conn.getConn().close();
            return c_list;
        }
    }
    
}
