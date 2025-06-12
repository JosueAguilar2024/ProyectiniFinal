/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectinifinal;


import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author josue
 */
public class ListaDobleMultas {
    private NodoMulta cabeza;
    private NodoMulta cola;

    public void insertar(Multa multa) {
        NodoMulta nuevo = new NodoMulta(multa);
        if (cabeza == null) {
            cabeza = cola = nuevo;
        } else {
            cola.setSiguiente(nuevo);
            nuevo.setAnterior(cola);
            cola = nuevo;
        }
    }

    public NodoMulta getCabeza() {
        return cabeza;
    }
    
 public ArrayList<Multa> buscarMultasPorPlacaBidireccional(String placa) {
        ArrayList<Multa> resultado = new ArrayList<>();
        NodoMulta desdeInicio = cabeza;
        NodoMulta desdeFin = cola;

        while (desdeInicio != null && desdeFin != null && 
               // Mientras no se crucen o igualen
               (desdeInicio != desdeFin) && (desdeInicio.getAnterior() != desdeFin)) {

            if (desdeInicio.getMulta().getPlaca().equalsIgnoreCase(placa)) {
                resultado.add(desdeInicio.getMulta());
            }

            if (desdeFin.getMulta().getPlaca().equalsIgnoreCase(placa)) {
                resultado.add(desdeFin.getMulta());
            }

            desdeInicio = desdeInicio.getSiguiente();
            desdeFin = desdeFin.getAnterior();
        }

        // Si los punteros se encuentran en el mismo nodo, chequeamos ese nodo solo una vez
        if (desdeInicio != null && desdeInicio == desdeFin) {
            if (desdeInicio.getMulta().getPlaca().equalsIgnoreCase(placa)) {
                resultado.add(desdeInicio.getMulta());
            }
        }

        return resultado;
    }
 public boolean existePlaca(String placa) {
    NodoMulta actual = cabeza;
    while (actual != null) {
        if (actual.getMulta().getPlaca().equalsIgnoreCase(placa)) {
            return true;
        }
        actual = actual.getSiguiente();
    }
    return false;
}


}
