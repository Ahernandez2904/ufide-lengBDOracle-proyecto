package com.mycompany.parqueo;

public class Main {
    public static void main(String[] args) {
        Conexion conexion = new Conexion();
        conexion.conn();
        conexion.closeConn();
    }
}
