package com.mycompany.parqueo;

import com.mycompany.parqueo.DAO.Detalle_FacturaDAO;
import java.sql.SQLException;

public class Detalle_Factura {
    private Detalle_FacturaDAO df = new Detalle_FacturaDAO();
    private int detalle_Fact_Id;
    private int factura_Id;
    private int inventario_Id;
    private int cantidad;
    private int subtotal;
    private int descuento;
    private int impuesto;
    private int total_Line;

    public int getDetalle_Fact_Id() {
        return detalle_Fact_Id;
    }

    public void setDetalle_Fact_Id(int detalle_Fact_Id) {
        this.detalle_Fact_Id = detalle_Fact_Id;
    }

    public int getFactura_Id() {
        return factura_Id;
    }

    public void setFactura_Id(int factura_Id) {
        this.factura_Id = factura_Id;
    }

    public int getInventario_Id() {
        return inventario_Id;
    }

    public void setInventario_Id(int inventario_Id) {
        this.inventario_Id = inventario_Id;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(int subtotal) {
        this.subtotal = subtotal;
    }

    public int getDescuento() {
        return descuento;
    }

    public void setDescuento(int descuento) {
        this.descuento = descuento;
    }

    public int getImpuesto() {
        return impuesto;
    }

    public void setImpuesto(int impuesto) {
        this.impuesto = impuesto;
    }

    public int getTotal_Line() {
        return total_Line;
    }

    public void setTotal_Line(int total_Line) {
        this.total_Line = total_Line;
    }
    
    
    
}
