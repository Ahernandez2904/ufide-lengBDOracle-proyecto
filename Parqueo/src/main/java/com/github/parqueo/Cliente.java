package com.github.parqueo;

import com.github.parqueo.DAO.ClienteDAO;

public class Cliente extends Persona {
    int codClinente;
    private ClienteDAO cl =new ClienteDAO();
    private String dni;
    private String direccion;
    private int distrito;
    
    public Cliente() {
    }
    
    public int registrar(String nombre, String apellidos, String dni, String direccion, int distrito){
        this.dni = dni;
        this.direccion = direccion;
        this.distrito = distrito;
        
        super.setNombre(nombre);
        super.setApellido(apellidos);
        super.setDireccion(direccion);
        //cl.insertCliente(this);
        return codClinente;
    }
}