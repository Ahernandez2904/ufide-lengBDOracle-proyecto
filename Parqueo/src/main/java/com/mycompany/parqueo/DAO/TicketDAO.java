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
import java.sql.SQLException;
import java.sql.Types;
import javax.swing.JOptionPane;

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
        String sqlString = "{call usp_insTicket (?,?,?,?,?,?,?)}";
        try {
            conn.openConn();
            CallableStatement cstm = conn.getConn().prepareCall(sqlString);
            cstm.setDate(1, ticket.getFecha_Creacion());
            cstm.setDate(2, ticket.getFecha_Entrada());
            cstm.setDate(3, ticket.getFecha_Salida());
            cstm.setInt(4, ticket.getInventario_Id());
            cstm.setInt(5, ticket.getVehiculo_Id());
            cstm.setInt(6, ticket.getEstado_Id());
            cstm.setInt(7, ticket.getEspacio_Id());
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
    
}
