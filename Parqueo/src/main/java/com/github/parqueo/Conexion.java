package com.github.parqueo;

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

    public void closeConn() {
        try {
            conn.close();
        } catch (Exception e) {
            System.out.println("Error al tratar de cerrar la conexion: " + HOSTNAME
                    + "\nError: " + e + "\n");
        }

    }
    
    public Statement pStm (String stm, String[] parameters){
        try{
            conn.prepareStatement(stm);
            return this.stm;
        }catch(SQLException se){
            return this.stm;
        }       
    }
}

/*
    public LinkedList<String> query(String from){
        try {
            Statement st = conn();
            ResultSet resultSet = st.executeQuery(from);
            
            LinkedList<String> result = new LinkedList();
            while (resultSet.next()){
                for (int i = 1; i < resultSet.getMetaData().getColumnCount();i++){
                    result.add(resultSet.getString(i));
                }
            }
            return result;
        }catch(Exception e){
            return  null;
        }
    }
 */

