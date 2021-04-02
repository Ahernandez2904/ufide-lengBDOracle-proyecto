package com.mycompany.parqueo;

public class Main {
    public static void main(String[] args) {
        //Probando conexión
        Conexion conexion = new Conexion();
        conexion.openConn();        
        conexion.closeConn();
    }
}
