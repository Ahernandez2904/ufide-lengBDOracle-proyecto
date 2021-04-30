/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.parqueo.DAO;

import com.mycompany.parqueo.Conexion;
import com.mycompany.parqueo.Ticket;
import java.sql.CallableStatement;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import oracle.jdbc.OracleTypes;

/**
 *
 * @author Ale
 */
public class TicketDAO extends Conexion {
    
    private Ticket ticket;
    private Conexion conn;
    
    public TicketDAO() {  }
    
    public Ticket usp_insTicket(Ticket t) throws SQLException {
        this.ticket = t;
        String sqlString = "{call usp_insTicket (?,?,?,?,?,?,?,?)}";
        conn = new Conexion();
        
        try {
            conn.openConn();
            System.out.println(ticket.getFecha_Entrada());
            CallableStatement cstm = conn.getConn().prepareCall(sqlString);
            cstm.setDate(1, ticket.getFecha_Entrada());
            cstm.setDate(2, ticket.getFecha_Salida());
            cstm.setInt(3, ticket.getInventario_Id());
            cstm.setInt(4, ticket.getVehiculo_Id());
            cstm.setInt(5, ticket.getEstado_Id());
            cstm.setInt(6, ticket.getEspacio_Id());
            cstm.registerOutParameter("ticket_id", Types.INTEGER);
            cstm.execute();
            ticket.setVehiculo_Id(cstm.getInt("ticket_id"));
            conn.getConn().commit();
            conn.getConn().close();
            return ticket;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            conn.getConn().close();
            return ticket;
        }
    }
    
        public Ticket USP_SELTICKET(int id) throws SQLException {
        String sqlString = "{call USP_SELTICKET (?,?)}";
        conn = new Conexion();
    
        try {
            conn.openConn();
            CallableStatement cstm = conn.getConn().prepareCall(sqlString);
            cstm.setInt(1, id);
            cstm.registerOutParameter(2, OracleTypes.CURSOR);
            cstm.executeUpdate();
            ResultSet rs = (ResultSet) cstm.getObject(2);
            while (rs.next()) {
                ticket = new Ticket();
                ticket.setTicket_Id(rs.getInt("ticket_id"));
                ticket.setEspacio_Id(rs.getInt("espacio_id"));
                ticket.setEstado_Id(rs.getInt("estado_id"));
                ticket.setInventario_Id(rs.getInt("inventario_id"));
                ticket.setVehiculo_Id(rs.getInt("setVehiculo_Id"));
                ticket.setFecha_Creacion(rs.getDate("fecha_creaacion"));
                ticket.setFecha_Entrada(rs.getDate("fecha_entrada"));
            }
            conn.getConn().close();
            return ticket;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            conn.getConn().close();
            return ticket;
        }
    }
    
}
