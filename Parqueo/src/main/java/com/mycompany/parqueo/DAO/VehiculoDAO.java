package com.mycompany.parqueo.DAO;

import com.mycompany.parqueo.Conexion;
import com.mycompany.parqueo.Parqueo;
import com.mycompany.parqueo.Vehiculo;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import javax.swing.JOptionPane;
import oracle.jdbc.OracleTypes;

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
    
    public Vehiculo USP_SELVEHICULO(String pl) throws SQLException {
        String sqlString = "{call USP_SELVEHICULO (?,?)}";
        conn = new Conexion();
    
        try {
            conn.openConn();
            CallableStatement cstm = conn.getConn().prepareCall(sqlString);
            cstm.setString(1, pl);
            cstm.registerOutParameter(2, OracleTypes.CURSOR);
            cstm.executeUpdate();
            ResultSet rs = (ResultSet) cstm.getObject(2);
            while (rs.next()) {
                vehiculo = new Vehiculo();
                vehiculo.setVehiculo_Id(rs.getInt("vehiculo_id"));
                vehiculo.setPlaca(rs.getString("placa"));
                vehiculo.setTipo_Vehiculo_Id(rs.getInt("tipo_Vehiculo_Id"));
                vehiculo.setMarca(rs.getString("marca"));
                vehiculo.setModelo(rs.getInt("modelo"));
                vehiculo.setColor_Hex(rs.getString("Color_Hex"));
            }
            conn.getConn().close();
            return vehiculo;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            conn.getConn().close();
            return vehiculo;
        }
    }
    
}
