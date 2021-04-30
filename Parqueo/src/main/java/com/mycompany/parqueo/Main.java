package com.mycompany.parqueo;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        //Probando conexión
        Conexion conn = new Conexion();
        conn.openConn();
        conn.getConn().close();
}}
