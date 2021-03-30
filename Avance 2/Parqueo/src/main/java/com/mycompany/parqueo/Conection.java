/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.parqueo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;

public class Conection {
    private Connection connection;
    
    public Conection() {
    }
    
    public Statement conn(){
        try {
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            System.out.println("Conectando a DB...");
            connection = DriverManager.getConnection("jdbc:oracle:thin:@104.215.101.47:1521:orcldev","lsalazar","orcldev");
            Statement statement = connection.createStatement();
            return statement;            
        }catch (Exception e) {
            System.out.println("Error: " + e);
            return  null;
        }
    }
    
    public void closeConn(){
        try {
            connection.close();
        }catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
    
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
    
}
