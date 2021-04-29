/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.parqueo;

import com.mycompany.parqueo.DAO.Espacio_ParqueoDAO;
import java.sql.SQLException;

public class Espacio_Parqueo {
    private Espacio_ParqueoDAO ep = new Espacio_ParqueoDAO();
    private int espacio_Id;
    private int categoria_Id;
    private int estado_Id;
    private int seccion_Id;

    public int getEspacio_Id() {
        return espacio_Id;
    }

    public void setEspacio_Id(int espacio_Id) {
        this.espacio_Id = espacio_Id;
    }

    public int getCategoria_Id() {
        return categoria_Id;
    }

    public void setCategoria_Id(int categoria_Id) {
        this.categoria_Id = categoria_Id;
    }

    public int getEstado_Id() {
        return estado_Id;
    }

    public void setEstado_Id(int estado_Id) {
        this.estado_Id = estado_Id;
    }

    public int getSeccion_Id() {
        return seccion_Id;
    }

    public void setSeccion_Id(int seccion_Id) {
        this.seccion_Id = seccion_Id;
    }
    
    
    
}
