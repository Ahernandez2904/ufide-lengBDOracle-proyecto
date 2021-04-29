package com.mycompany.parqueo.DAO;

import com.mycompany.parqueo.Conexion;
import com.mycompany.parqueo.Seccion_Parqueo;
import java.sql.CallableStatement;
import java.sql.SQLException;
import java.sql.Types;
import javax.swing.JOptionPane;

public class Seccion_ParqueoDAO extends Conexion  {
    private Seccion_Parqueo seccion_Parqueo;
    private Conexion conn;
    
    public Seccion_ParqueoDAO() { }
    
}
