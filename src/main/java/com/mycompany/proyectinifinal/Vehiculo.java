/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectinifinal;

/**
 *
 * @author josue
 */
public class Vehiculo {
    private String placa;
    private String marca;
    private String modelo;
    private String color;
    private String propietario;
    private String dpi;
    private String departamento;
    private String anio;

    public Vehiculo(String placa, String marca, String modelo, String color, String propietario, String dpi, String departamento, String anio) {
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.propietario = propietario;
        this.dpi = dpi;
        this.departamento = departamento;
        this.anio = anio;
    }

    public String getPlaca() { return placa; }
    public String getMarca() { return marca; }
    public String getModelo() { return modelo; }
    public String getColor() { return color; }
    public String getPropietario() { return propietario; }
    public String getDpi() { return dpi; }
    public String getDepartamento() { return departamento; }
    public String getAnio() { return anio; }
}

