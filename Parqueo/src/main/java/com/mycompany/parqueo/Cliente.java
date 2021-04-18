package com.mycompany.parqueo;

import com.mycompany.parqueo.DAO.ClienteDAO;
import java.sql.SQLException;

public class Cliente extends Persona {
    int codClinente;
    private ClienteDAO cl =new ClienteDAO();
    private String direccion;
    private int distrito;
    
    public Cliente() {
    }

    public int getCodClinente() {
        return codClinente;
    }

    public void setCodClinente(int codClinente) {
        this.codClinente = codClinente;
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
    
    public int registrar(String nombre, String apellido1, String apellido2, String dni, String direccion, int distrito) throws SQLException{
        this.direccion = direccion;
        this.distrito = distrito;
        super.setNombre(nombre);
        super.setApellido1(apellido1);
        super.setApellido2(apellido2);
        super.setDni(dni);
        
        cl.insertCliente(this);
        return codClinente;
    }
}