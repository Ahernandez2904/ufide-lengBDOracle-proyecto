package com.github.parqueo;

import com.github.parqueo.DAO.ClienteDAO;

public class Cliente extends Persona {

    private int id;
    private String direccion;
    private int distrito;
    private ClienteDAO cl = new ClienteDAO();

    public Cliente() {
    }

    public int getId() {
        return id;
    }

    public void setId(int codClinente) {
        this.id = codClinente;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getDistrito() {
        return distrito;
    }

    public void setDistrito(int distrito) {
        this.distrito = distrito;
    }
    //cl.insertCliente(this);
}