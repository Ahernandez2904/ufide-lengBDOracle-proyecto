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
public class MainTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Conection conection = new Conection();
        conection.conn();
        conection.closeConn();
    }
    
}