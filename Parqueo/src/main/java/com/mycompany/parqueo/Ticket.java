package com.mycompany.parqueo;

import com.mycompany.parqueo.DAO.TicketDAO;
import java.sql.Date;
//import java.util.Date;
import java.sql.SQLException;

public class Ticket {
    private TicketDAO t = new TicketDAO();
    private int ticket_Id;
    private Date fecha_Creacion;
    private Date fecha_Entrada;
    private Date fecha_Salida;
    private int inventario_Id;
    private int vehiculo_Id;
    private int estado_Id;
    private int espacio_Id;

    public int getTicket_Id() {
        return ticket_Id;
    }

    public void setTicket_Id(int ticket_Id) {
        this.ticket_Id = ticket_Id;
    }

    public Date getFecha_Creacion() {
        return fecha_Creacion;
    }

    public void setFecha_Creacion(Date fecha_Creacion) {
        this.fecha_Creacion = fecha_Creacion;
    }

    public Date getFecha_Entrada() {
        return fecha_Entrada;
    }

    public void setFecha_Entrada(Date fecha_Entrada) {
        this.fecha_Entrada = fecha_Entrada;
    }

    public Date getFecha_Salida() {
        return fecha_Salida;
    }

    public void setFecha_Salida(Date fecha_Salida) {
        this.fecha_Salida = fecha_Salida;
    }

    public int getInventario_Id() {
        return inventario_Id;
    }

    public void setInventario_Id(int inventario_Id) {
        this.inventario_Id = inventario_Id;
    }

    public int getVehiculo_Id() {
        return vehiculo_Id;
    }

    public void setVehiculo_Id(int vehiculo_Id) {
        this.vehiculo_Id = vehiculo_Id;
    }

    public int getEstado_Id() {
        return estado_Id;
    }

    public void setEstado_Id(int estado_Id) {
        this.estado_Id = estado_Id;
    }

    public int getEspacio_Id() {
        return espacio_Id;
    }

    public void setEspacio_Id(int espacio_Id) {
        this.espacio_Id = espacio_Id;
    }
    
    public int insertar(Date fecha_Entrada, Date fecha_Salida, int inventario_Id, int vehiculo_Id, int estado_Id, int espacio_Id) throws SQLException {
        this.setFecha_Entrada(fecha_Entrada);
        this.setFecha_Salida(fecha_Salida);
        this.setInventario_Id(inventario_Id);
        this.setVehiculo_Id(vehiculo_Id);
        this.setEstado_Id(estado_Id);
        this.setEspacio_Id(espacio_Id);
        t.usp_insTicket(this);
        return this.getTicket_Id();
    }
    
}
