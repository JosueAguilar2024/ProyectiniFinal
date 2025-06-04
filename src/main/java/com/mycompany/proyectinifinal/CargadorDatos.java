/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectinifinal;

import java.io.*;
import java.util.*;
public class CargadorDatos {
    private ArbolVehiculos arbolVehiculos = new ArbolVehiculos();

    public void cargarDesdeCarpeta(File carpeta) {
        if (carpeta.exists() && carpeta.isDirectory()) {
            cargarRecursivo(carpeta);
        } else {
            System.out.println("La ruta no es válida.");
        }
    }

 private void cargarRecursivo(File carpeta) {
    for (File archivo : carpeta.listFiles()) {
        if (archivo.isDirectory()) {
            cargarRecursivo(archivo); // recorrer subcarpetas
        } else if (archivo.getName().toLowerCase().endsWith(".txt")) {
            String nombre = archivo.getName().toLowerCase();
            
            if (nombre.contains("vehiculos")) {
                cargarDesdeArchivo(archivo);
            } else if (nombre.contains("multas")) {
                cargarMultasDesdeArchivo(archivo);
            } else if (nombre.contains("traspasos")) {
                cargarTraspasosDesdeArchivo(archivo)
            }
        }
    }
    }

  private void cargarDesdeArchivo(File archivo) {
try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
        String linea;
        boolean primeraLinea = true;
        
        while ((linea = br.readLine()) != null) {
            if (primeraLinea) {
                primeraLinea = false;
                continue; // saltar encabezado
            }
            String[] partes = linea.split(",");
            if (partes.length < 8) continue;

            String placaLimpia = partes[0].trim().toUpperCase();
            Vehiculo v = new Vehiculo(
                placaLimpia,
                partes[1].trim(), partes[2].trim(), partes[3].trim(),
                partes[4].trim(), partes[5].trim(), partes[6].trim(), partes[7].trim()
            );
            arbolVehiculos.insertar(v);
        }
    } catch (IOException e) {
        System.out.println("Error al leer archivo de vehículos: " + archivo.getName());
    }
}


    public ArbolVehiculos getArbolVehiculos() {
        return arbolVehiculos;
    }
}
