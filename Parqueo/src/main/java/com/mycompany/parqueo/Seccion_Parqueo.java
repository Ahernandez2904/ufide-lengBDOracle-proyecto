package com.mycompany.parqueo;

import com.mycompany.parqueo.DAO.Seccion_ParqueoDAO;
import java.sql.SQLException;

public class Seccion_Parqueo {
    private Seccion_ParqueoDAO sp = new Seccion_ParqueoDAO();
    private int seccion_Id;
    private String descripcion;
    private int parqueo_Id;
    private int estado_Id;

    public int getSeccion_Id() {
        return seccion_Id;
    }

    public void setSeccion_Id(int seccion_Id) {
        this.seccion_Id = seccion_Id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getParqueo_Id() {
        return parqueo_Id;
    }

    public void setParqueo_Id(int parqueo_Id) {
        this.parqueo_Id = parqueo_Id;
    }

    public int getEstado_Id() {
        return estado_Id;
    }

    public void setEstado_Id(int estado_Id) {
        this.estado_Id = estado_Id;
    }
    
}
