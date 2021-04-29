package com.mycompany.parqueo;

import com.mycompany.parqueo.DAO.ClienteDAO;
import java.sql.SQLException;

public class Cliente extends Persona {
    private int codCliente;
    private ClienteDAO cl = new ClienteDAO();
    private int estado_Cliente;
    private int detalle_Dir_Id;
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
    
    public int insertar(String nombre, String primer_Apellido, String segundo_Apellido, String dni, int detalle_Dir_Id, int estado_cliente) throws SQLException{
        super.setNombre(nombre);
        super.setPrimer_Apellido(primer_Apellido);
        super.setSegundo_Apellido(segundo_Apellido);
        super.setDni(dni);
        this.setEstado_Cliente(estado_cliente);
        this.setDetalle_Dir_Id(detalle_Dir_Id);
        cl.usp_insCliente(this);
        return codCliente;
    }
    
}