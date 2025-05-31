/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectinifinal;

/**
 *
 * @author josue
 */
public class ArbolVehiculos {
    private NodoVehiculo raiz;

    public void insertar(Vehiculo v) {
        // No modificamos placa aquí
        raiz = insertarRecursivo(raiz, v);
    }

    private NodoVehiculo insertarRecursivo(NodoVehiculo actual, Vehiculo v) {
        if (actual == null) {
            return new NodoVehiculo(v);
        }
        if (v.getPlaca().compareTo(actual.vehiculo.getPlaca()) < 0) {
            actual.izquierdo = insertarRecursivo(actual.izquierdo, v);
        } else if (v.getPlaca().compareTo(actual.vehiculo.getPlaca()) > 0) {
            actual.derecho = insertarRecursivo(actual.derecho, v);
        }
        return actual;
    }

    public Vehiculo buscar(String placa) {
        return buscarRecursivo(raiz, placa.toUpperCase());  // Aquí está bien forzar mayúsculas para buscar
    }

    private Vehiculo buscarRecursivo(NodoVehiculo actual, String placa) {
        if (actual == null) return null;
        if (actual.vehiculo.getPlaca().equalsIgnoreCase(placa)) return actual.vehiculo;
        if (placa.compareTo(actual.vehiculo.getPlaca()) < 0) {
            return buscarRecursivo(actual.izquierdo, placa);
        } else {
            return buscarRecursivo(actual.derecho, placa);
        }
    }
}

