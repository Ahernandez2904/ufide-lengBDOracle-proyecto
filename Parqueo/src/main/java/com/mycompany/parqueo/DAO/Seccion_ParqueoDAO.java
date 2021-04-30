package com.mycompany.parqueo.DAO;

import com.mycompany.parqueo.Conexion;
import com.mycompany.parqueo.Parqueo;
import com.mycompany.parqueo.Seccion_Parqueo;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import oracle.jdbc.OracleTypes;

public class Seccion_ParqueoDAO extends Conexion {

    private Seccion_Parqueo seccion_Parqueo;
    private Conexion conn;

    public List<Seccion_Parqueo> usp_sel_totalSeccionParqueo(Parqueo p) throws SQLException {
        List<Seccion_Parqueo> l_sp = new ArrayList<Seccion_Parqueo>();
        String sqlString = "{call USP_SEL_TOTALSECCIONES_PARQUEO (?,?)}";
        conn = new Conexion();

        try {
            conn.openConn();
            CallableStatement cstm = conn.getConn().prepareCall(sqlString);
            cstm.setInt(1, p.getParqueo_Id());
            cstm.registerOutParameter(2, OracleTypes.CURSOR);
            cstm.execute();
            ResultSet rs = (ResultSet) cstm.getObject(2);
            while (rs.next()) {
                seccion_Parqueo = new Seccion_Parqueo();
                seccion_Parqueo.setSeccion_Id(rs.getInt("seccion_id"));
                seccion_Parqueo.setDescripcion(rs.getString("descripcion"));
                seccion_Parqueo.setParqueo_Id(rs.getInt("parqueo_id"));
                seccion_Parqueo.setEstado_Id(rs.getInt("estado_id"));
                l_sp.add(seccion_Parqueo);
            }
            conn.getConn().close();
            return l_sp;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            conn.getConn().close();
            return l_sp;
        }
    }

}
