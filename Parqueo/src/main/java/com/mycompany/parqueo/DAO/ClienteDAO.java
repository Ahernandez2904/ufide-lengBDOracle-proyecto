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
public class ClienteDAO {
    private Conexion conn;
    private Cliente cliente;

    public ClienteDAO() {
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Cliente insert(Cliente c) throws SQLException {
        Cliente cliente = c;
        String sqlString = "{call usp_insCliente (?,?,?,?,?,?,?)}";
        conn = new Conexion();
        try {
            conn.openConn();
            CallableStatement cstm = conn.getConn().prepareCall(sqlString);
            cstm.setString(1, cliente.getNombre());
            cstm.setString(2, cliente.getApellido1());
            cstm.setString(3, cliente.getApellido2());
            cstm.setString(4, cliente.getDni());
            cstm.setString(5, cliente.getDireccion());
            cstm.setInt(6, cliente.getDistrito());
            cstm.registerOutParameter(7, Types.INTEGER);
            cstm.execute();
            cliente.setId(cstm.getInt(7));
            conn.getConn().commit();
            conn.getConn().close();
            return cliente;
        } catch (Exception e) {
            System.out.println(e);
            conn.getConn().close();
            return cliente;
        }
    }
}
