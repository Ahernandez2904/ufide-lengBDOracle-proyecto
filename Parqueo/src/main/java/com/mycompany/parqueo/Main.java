package com.mycompany.parqueo;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        //Probando conexión
        
        Cliente c = new Cliente();
        try {
            c.insertar("Pedro", "Jimenez", "Perez", "123412345", "Dir", 1);
        } catch (Exception e) {
            System.out.println("Error: "+e);
        }        
    }
}
