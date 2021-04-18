package com.mycompany.parqueo.DAO;

import com.mycompany.parqueo.Cliente;
import com.mycompany.parqueo.Conexion;
import java.sql.CallableStatement;
import java.sql.SQLException;
import java.sql.Types;
import javax.swing.JOptionPane;

/**
 * LastUpdate: 01/04/21
 *
 * @author lsalazar Description: Permite el menejo de los datos de la calse
 * cliente con la DB
 */
public class ClienteDAO extends Conexion {

    private Cliente cliente;
    private Conexion conn;

    public ClienteDAO() {
    }

    public Cliente insertCliente(Cliente cl) throws SQLException {
        this.cliente = cl;
        String sqlString = "{call usp_insCliente (?,?,?,?,?,?)}";
        try {
            conn.openConn();
            CallableStatement cstm = conn.getConn().prepareCall(sqlString);
            cstm.setString(1, cliente.getNombre());
            cstm.setString(2, cliente.getApellido1());
            cstm.setString(3, cliente.getApellido2());
            cstm.setString(4, cliente.getDni());
            cstm.setString(5, cliente.getDireccion());
            cstm.setInt(6, cliente.getDistrito());
            cstm.registerOutParameter("cliente_id", Types.INTEGER);
            cstm.execute();
            cliente.setCodClinente(cstm.getInt("cliente_id"));
            conn.getConn().commit();
            conn.getConn().close();
            return cliente;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            conn.getConn().close();
            return cliente;
        }
    }
}
