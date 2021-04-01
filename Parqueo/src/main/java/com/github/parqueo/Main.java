package com.github.parqueo;

public class Main {
    public static void main(String[] args) {
        Conexion conexion = new Conexion();
        conexion.openConn();        
        conexion.closeConn();
    }
}
