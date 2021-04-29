
package com.mycompany.parqueo;

import com.mycompany.parqueo.DAO.EstadoDAO;
import java.sql.SQLException;

public class Estado {
    private EstadoDAO es = new EstadoDAO();
    private int estado_Id;
    private String descripcion;
    private int categoria_Id;

    public int getEstado_Id() {
        return estado_Id;
    }

    public void setEstado_Id(int estado_Id) {
        this.estado_Id = estado_Id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCategoria_Id() {
        return categoria_Id;
    }

    public void setCategoria_Id(int categoria_Id) {
        this.categoria_Id = categoria_Id;
    }
    
    
}
