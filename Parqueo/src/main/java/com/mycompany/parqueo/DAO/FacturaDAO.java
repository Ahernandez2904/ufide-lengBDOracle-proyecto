package com.mycompany.parqueo.DAO;

import com.mycompany.parqueo.Factura;
import com.mycompany.parqueo.Conexion;
import java.sql.CallableStatement;
import java.sql.SQLException;
import java.sql.Types;
import javax.swing.JOptionPane;

public class FacturaDAO extends Conexion {
    private Factura factura;
    private Conexion conn;

    public FacturaDAO() { }
    
    public Factura usp_insFactura(Factura f) throws SQLException {
        this.factura = f;
        String sqlString = "{call usp_insFactura (?,?,?,?)}";
        try {
            conn.openConn();
            CallableStatement cstm = conn.getConn().prepareCall(sqlString);
            cstm.setDate(1, factura.getFecha_Creacion()); //falta convertir al formato
            cstm.setInt(2, factura.getCliente_Id());
            cstm.setInt(3, factura.getEstado_Id());
            cstm.setInt(6, factura.getTotal_Factura());
            cstm.registerOutParameter("cliente_id", Types.INTEGER);
            cstm.execute();
            factura.setFactura_Id(cstm.getInt("FACTURA_IDFAC"));
            conn.getConn().commit();
            conn.getConn().close();
            return factura;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            conn.getConn().close();
            return factura;
        }
        
    }
    
}
