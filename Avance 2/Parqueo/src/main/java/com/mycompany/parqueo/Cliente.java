/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.parqueo;

/**
 *
 * @author lsalazar
 */
public class Cliente extends Persona {
    int codClinente;
    
    public Cliente() {
    }
    
    public int registrar(String nombre, String apellidos, String direccion, int distrito, String telefono, String Correo){
        super.setNombre(nombre);
        super.setApellido(apellidos);
        super.setDireccion(direccion);
        //Codigo para insertar un cliente en DB.
        return codClinente;
    }
    
}
