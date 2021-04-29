package com.mycompany.parqueo;

import com.mycompany.parqueo.DAO.VehiculoDAO;
import java.sql.SQLException;

public class Vehiculo {
    private VehiculoDAO v = new VehiculoDAO();
    private int vehiculo_Id; 
    private String placa; 
    private int tipo_Vehiculo_Id; 
    private String marca; 
    private int modelo; 
    private String color_Hex;

    public int getVehiculo_Id() {
        return vehiculo_Id;
    }

    public void setVehiculo_Id(int vehiculo_Id) {
        this.vehiculo_Id = vehiculo_Id;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public int getTipo_Vehiculo_Id() {
        return tipo_Vehiculo_Id;
    }

    public void setTipo_Vehiculo_Id(int tipo_Vehiculo_Id) {
        this.tipo_Vehiculo_Id = tipo_Vehiculo_Id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getModelo() {
        return modelo;
    }

    public void setModelo(int modelo) {
        this.modelo = modelo;
    }

    public String getColor_Hex() {
        return color_Hex;
    }

    public void setColor_Hex(String color_Hex) {
        this.color_Hex = color_Hex;
    }
    
    public int insertar(String placa, int tipo_Vehiculo_Id, String marca, int modelo, String color_Hex) throws SQLException {
        this.setPlaca(placa);
        this.setTipo_Vehiculo_Id(tipo_Vehiculo_Id);
        this.setMarca(marca);
        this.setModelo(modelo);
        this.setColor_Hex(color_Hex);
        v.usp_insVehiculo(this);
        return this.getVehiculo_Id();
    }

}
