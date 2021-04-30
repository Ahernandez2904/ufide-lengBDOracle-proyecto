package com.mycompany.parqueo.DAO;

import com.mycompany.parqueo.Conexion;
import com.mycompany.parqueo.Espacio_Parqueo;
import com.mycompany.parqueo.Estado;
import com.mycompany.parqueo.Seccion_Parqueo;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import oracle.jdbc.OracleTypes;

public class Espacio_ParqueoDAO extends Conexion  {
    private Espacio_Parqueo espacio_Parqueo;
    private Estado e;
    private Conexion conn;
    
    public List<Espacio_Parqueo> usp_selespacio_parqueo(Seccion_Parqueo sp) throws SQLException {
        List<Espacio_Parqueo> l_ep = new ArrayList<Espacio_Parqueo>();
        String sqlString = "{call USP_SELESPACIO_PARQUEO (?,?,?)}";
        conn = new Conexion();
        try {
            conn.openConn();
            CallableStatement cstm = conn.getConn().prepareCall(sqlString);
            cstm.setInt(1, 81); //Estado disponible
            System.out.println(sp.getSeccion_Id());
            cstm.setInt(2, sp.getSeccion_Id());
            cstm.registerOutParameter(3, OracleTypes.CURSOR);
            cstm.execute();
            ResultSet rs = (ResultSet) cstm.getObject(3);
            while (rs.next()) {
                espacio_Parqueo = new Espacio_Parqueo();
                espacio_Parqueo.setEspacio_Id(rs.getInt("espacio_id"));
                espacio_Parqueo.setCategoria_Id(rs.getInt("categoria_id"));
                espacio_Parqueo.setSeccion_Id(rs.getInt("seccion_id"));
                e = new Estado();
                e.setEstado_Id(rs.getInt("estado_id"));
                e.setDescripcion(rs.getString("descripcion"));
                espacio_Parqueo.setEstado(e);
                l_ep.add(espacio_Parqueo);
            }
            conn.getConn().close();
            return l_ep;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            conn.getConn().close();
            return l_ep;
        }
    }
    
}
