package com.mycompany.parqueo.DAO;

import com.mycompany.parqueo.Parqueo;
import com.mycompany.parqueo.Conexion;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import oracle.jdbc.OracleCallableStatement;
import oracle.jdbc.OracleTypes;

public class ParqueoDAO extends Conexion {
    private Parqueo parqueo;
    private Conexion conn;
    
    public ParqueoDAO() { }
    
    public List<Parqueo> usp_sel_totalParqueo() throws SQLException {
        List<Parqueo> parqueos = new ArrayList<Parqueo>();
        String sqlString = "{call usp_sel_totalParqueo (?)}";
        
        try {
            conn.openConn();
            CallableStatement cstm = conn.getConn().prepareCall(sqlString);
            cstm.registerOutParameter(1, OracleTypes.CURSOR);
            cstm.executeQuery();
            ResultSet rs = cstm.getObject(1, ResultSet.class);
            conn.getConn().commit();
            while (rs.next()) {
                parqueo = new Parqueo();
                parqueo.setDescripcion(rs.getString("descripcion"));
                parqueo.setDetalle_Dir_Id(rs.getInt("detalle_dir_id"));
                parqueo.setParqueo_Id(rs.getInt("parqueo_id"));
                parqueo.setEstado_Id(rs.getInt("estado_id"));
                parqueos.add(parqueo);
            }
            conn.getConn().close();
            return parqueos;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            conn.getConn().close();
            return parqueos;
        }
    }
}
