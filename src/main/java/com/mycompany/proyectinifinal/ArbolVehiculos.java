/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectinifinal;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

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
        return buscarRecursivo(raiz, placa.toUpperCase());
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
    
    public void recorrerInorden(JTable tabla) {
    DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
    modelo.setRowCount(0);
    recorrerInorden(raiz, modelo);
}

private void recorrerInorden(NodoVehiculo nodo, DefaultTableModel modelo) {
    if (nodo != null) {
        recorrerInorden(nodo.izquierdo, modelo);
        agregarAFila(nodo.vehiculo, modelo);
        recorrerInorden(nodo.derecho, modelo);
    }
}

public void recorrerPreorden(JTable tabla) {
    DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
    modelo.setRowCount(0);
    recorrerPreorden(raiz, modelo);
}

private void recorrerPreorden(NodoVehiculo nodo, DefaultTableModel modelo) {
    if (nodo != null) {
        agregarAFila(nodo.vehiculo, modelo);
        recorrerPreorden(nodo.izquierdo, modelo);
        recorrerPreorden(nodo.derecho, modelo);
    }
}

public void recorrerPostorden(JTable tabla) {
    DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
    modelo.setRowCount(0);
    recorrerPostorden(raiz, modelo);
}

private void recorrerPostorden(NodoVehiculo nodo, DefaultTableModel modelo) {
    if (nodo != null) {
        recorrerPostorden(nodo.izquierdo, modelo);
        recorrerPostorden(nodo.derecho, modelo);
        agregarAFila(nodo.vehiculo, modelo);
    }
}

private void agregarAFila(Vehiculo v, DefaultTableModel modelo) {
    modelo.addRow(new Object[]{
        v.getPlaca(),
        v.getMarca(),
        v.getModelo(),
        v.getAnio(),
        v.getMultas(),
        v.getTraspasos(),
        v.getPropietario(),
        v.getDpi()
    });
}

}

