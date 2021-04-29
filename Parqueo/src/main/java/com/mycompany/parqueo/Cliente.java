package com.mycompany.parqueo;

import com.mycompany.parqueo.DAO.ClienteDAO;
import java.sql.SQLException;

public class Cliente extends Persona {
    private ClienteDAO cl = new ClienteDAO();
    private int codCliente;
    private int estado_Cliente;
    private int detalle_Dir_Id;
    private String detalle_Dir;
    
    public Cliente() { }

    public int getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(int codCliente) {
        this.codCliente = codCliente;
    }
    
    public int getEstado_Cliente() {
        return estado_Cliente;
    }

    public void setEstado_Cliente(int estado_Cliente) {
        this.estado_Cliente = estado_Cliente;
    }

    public int getDetalle_Dir_Id() {
        return detalle_Dir_Id;
    }

    public void setDetalle_Dir_Id(int detalle_Dir_Id) {
        this.detalle_Dir_Id = detalle_Dir_Id;
    }
    
    public String getDetalle_Dir() {
        return detalle_Dir;
    }

    public void setDetalle_Dir(String detalle_Dir) {
        this.detalle_Dir = detalle_Dir;
    }
    
    public int insertar(String nombre, String primer_Apellido, String segundo_Apellido, String dni, String detalle_Dir, int estado_cliente) throws SQLException {
        super.setNombre(nombre);
        super.setPrimer_Apellido(primer_Apellido);
        super.setSegundo_Apellido(segundo_Apellido);
        super.setDni(dni);
        this.setEstado_Cliente(estado_cliente);
        this.setDetalle_Dir(detalle_Dir);
        cl.usp_insCliente(this);
        return this.getCodCliente();
    }
    
}