package com.mycompany.parqueo.DAO;

import com.mycompany.parqueo.Conexion;
import com.mycompany.parqueo.Vehiculo;
import java.sql.CallableStatement;
import java.sql.SQLException;
import java.sql.Types;
import javax.swing.JOptionPane;

public class VehiculoDAO extends Conexion {

    private Vehiculo vehiculo;
    private Conexion conn;
    
    public VehiculoDAO() {  }
    
    public Vehiculo usp_insVehiculo(Vehiculo v) throws SQLException {
        this.vehiculo = v;
        conn = new Conexion();
        String sqlString = "{call usp_insVehiculo (?,?,?,?,?,?)}";
        try {
            conn.openConn();
            CallableStatement cstm = conn.getConn().prepareCall(sqlString);
            cstm.setString(1, vehiculo.getPlaca());
            cstm.setInt(2, vehiculo.getTipo_Vehiculo_Id());
            cstm.setString(3, vehiculo.getMarca());
            cstm.setInt(4, vehiculo.getModelo());
            cstm.setString(5, vehiculo.getColor_Hex());
            cstm.registerOutParameter("vehiculo_id", Types.INTEGER);
            cstm.execute();
            vehiculo.setVehiculo_Id(cstm.getInt("vehiculo_id"));
            conn.getConn().commit();
            conn.getConn().close();
            return vehiculo;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            conn.getConn().close();
            return vehiculo;
        }
    }
    
}
