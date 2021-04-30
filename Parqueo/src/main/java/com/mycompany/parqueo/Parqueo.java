package com.mycompany.parqueo;

import com.mycompany.parqueo.DAO.ParqueoDAO;
import java.sql.SQLException;
import java.util.List;

public class Parqueo {
    private ParqueoDAO p = new ParqueoDAO();
    private int parqueo_Id;
    private String descripcion;
    private int detalle_Dir_Id;
    private int estado_Id;

    public int getParqueo_Id() {
        return parqueo_Id;
    }

    public void setParqueo_Id(int parqueo_Id) {
        this.parqueo_Id = parqueo_Id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getDetalle_Dir_Id() {
        return detalle_Dir_Id;
    }

    public void setDetalle_Dir_Id(int detalle_Dir_Id) {
        this.detalle_Dir_Id = detalle_Dir_Id;
    }

    public int getEstado_Id() {
        return estado_Id;
    }

    public void setEstado_Id(int estado_Id) {
        this.estado_Id = estado_Id;
    }
}
