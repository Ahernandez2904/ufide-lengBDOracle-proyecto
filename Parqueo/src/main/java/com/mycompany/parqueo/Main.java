package com.mycompany.parqueo;

import com.mycompany.parqueo.DAO.ClienteDAO;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) throws SQLException {
        //Probando conexión
        Cliente c = new Cliente();
        
        c.setNombre("Luis");
        c.setApellido1("Salazar");
        c.setApellido2("Cordoba");
        c.setDni("702070100");
        c.setDireccion("Casa 8A");
        c.setDistrito(1);
        
        ClienteDAO cdao = new ClienteDAO();
        Conexion con = new Conexion();
        
        c = cdao.insert(c);
        
        System.out.println("Se resgitro el cliente con el Id: "+ c.getId());
        
    }
}
