package com.mycompany.parqueo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

public class Conexion {

    private final String HOSTNAME = "104.215.101.47";
    private final String URL = "jdbc:oracle:thin:@" + HOSTNAME + ":1521:orcldev";
    private final String USER = "lsalazar";
    private final String PASSWORD = "abcd0987";
    private Connection conn;
    private Statement stm;

    public Conexion() {
    }

    public void openConn() {
        try {
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            System.out.println("Conectando a DB...");
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conectado a " + URL + "\n");
        } catch (Exception e) {
            System.out.println("Error al tratar de conectar a: " + HOSTNAME
                    + "\nError: " + e + "\n");
        }
    }

    public Connection getConn() {
        return conn;
    }
}
