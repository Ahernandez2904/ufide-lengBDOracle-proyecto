package com.mycompany.parqueo;

import com.mycompany.parqueo.DAO.FacturaDAO;
import java.sql.Date;
//import java.util.Date;
import java.sql.SQLException;

public class Factura {
    private FacturaDAO f = new FacturaDAO();
    private int factura_Id;
    private Date fecha_Creacion;
    private int cliente_Id;
    private int estado_Id;
    private int total_Factura;
    
    public Factura() {  }

    public int getFactura_Id() {
        return factura_Id;
    }

    public void setFactura_Id(int factura_Id) {
        this.factura_Id = factura_Id;
    }

    public Date getFecha_Creacion() {
        return fecha_Creacion;
    }

    public void setFecha_Creacion(Date fecha_Creacion) {
        this.fecha_Creacion = fecha_Creacion;
    }

    public int getCliente_Id() {
        return cliente_Id;
    }

    public void setCliente_Id(int cliente_Id) {
        this.cliente_Id = cliente_Id;
    }

    public int getEstado_Id() {
        return estado_Id;
    }

    public void setEstado_Id(int estado_Id) {
        this.estado_Id = estado_Id;
    }

    public int getTotal_Factura() {
        return total_Factura;
    }

    public void setTotal_Factura(int total_Factura) {
        this.total_Factura = total_Factura;
    }
    
    public int insertar(Date fecha_Creacion, int cliente_Id, int estado_Id, int total_Factura) throws SQLException {
        this.setFecha_Creacion(fecha_Creacion);
        this.setCliente_Id(cliente_Id);
        this.setEstado_Id(estado_Id);
        this.getTotal_Factura();
        f.usp_insFactura(this);
        return this.getFactura_Id();
    }
    
}
