/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectinifinal;

import java.io.*;
import java.util.*;
public class CargadorDatos {
    private ArbolVehiculos arbolVehiculos = new ArbolVehiculos();
    private ListaCircularTraspasos listasTraspasos = new ListaCircularTraspasos();
private ListaDobleMultas listaMultas = new ListaDobleMultas();
private ArbolAVL arbolAVL = new ArbolAVL(); 

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
            cargarRecursivo(archivo); 
        } else if (archivo.getName().toLowerCase().endsWith(".txt")) {
            String nombre = archivo.getName().toLowerCase();
            
            if (nombre.contains("vehiculos")) {
                cargarDesdeArchivo(archivo);
            } else if (nombre.contains("multas")) {
                cargarMultasDesdeArchivo(archivo);
            } else if (nombre.contains("traspasos")) {
                cargarTraspasosDesdeArchivo(archivo);
            }
        }
    }
    }
private void cargarMultasDesdeArchivo(File archivo) {
    try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
        String linea;
        boolean primeraLinea = true;
  
        String nombreArchivo = archivo.getName().toLowerCase();
        String departamento = nombreArchivo.replace(".txt", "")
                                           .replace("multas", "")
                                           .replace("_", "")
                                           .trim(); // limpiar nombre
        while ((linea = br.readLine()) != null) {
            if (primeraLinea) {
                primeraLinea = false;
                continue; // Saltar encabezado
            }

            String[] partes = linea.split(",");
            if (partes.length < 4) continue;

           Multa multa = new Multa(
                partes[0].trim(), 
                partes[1].trim(),
                partes[2].trim(),
                partes[3].trim(), 
                departamento 
                );


            listaMultas.insertar(multa);
        }

    } catch (IOException e) {
        System.out.println("Error al leer archivo de multas: " + archivo.getName());
    }
}
private void cargarTraspasosDesdeArchivo(File archivo) {
    String nombreTxt = archivo.getName().toLowerCase().replace(".txt", "");
String departamento = nombreTxt
        .replace("traspasos_", "")
        .replace("traspasos", "")
        .replace("_", "")
        .trim();

    try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
        String linea;
        boolean primeraLinea = true;

        while ((linea = br.readLine()) != null) {
            if (primeraLinea) {
                primeraLinea = false;
                continue; // Saltar encabezado
            }

            String[] p = linea.split(",");
           
            if (p.length < 6) continue;

            Traspaso t = new Traspaso(
                p[0].trim(),    
                p[1].trim(),   
                p[2].trim(),   
                p[3].trim(),    
                p[4].trim(),   
                p[5].trim(),   
                departamento    
            );
            listasTraspasos.insertar(t);
        }

    } catch (IOException e) {
        System.out.println("Error al leer archivo de traspasos: " + archivo.getName());
    }
}


  private void cargarDesdeArchivo(File archivo) {
   String nombre = archivo.getName().toLowerCase().replace(".txt", "");
    String departamento = nombre.replace("vehiculos_", "")
                                .replace("vehiculos", "")
                                .replace("_", "")
                                .trim();

    try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
        String linea;
        boolean primera = true;
        while ((linea = br.readLine()) != null) {
            if (primera) {
            primera = false; 
            continue; }

            String[] campos = linea.split(",");
            if (campos.length < 8) continue; 

            Vehiculo v = new Vehiculo(
                campos[0].trim(),  
                campos[1].trim(),  
                campos[2].trim(), 
                campos[3].trim(),  
                campos[4].trim(),  
                campos[5].trim(),  
                campos[6].trim(), 
                campos[7].trim(), 
                departamento       
            );

            arbolVehiculos.insertar(v);
            arbolAVL.insertar(v);
        }
    } catch (IOException e) {
        System.out.println("Error al leer archivo de vehiculos: " + archivo.getName());
    }
}


    public ArbolVehiculos getArbolVehiculos() {
        return arbolVehiculos;
    }

  
    public ListaDobleMultas getListaMultas() {
        return listaMultas;
    }

    public ListaCircularTraspasos getListaTraspasos() {
        return listasTraspasos;   
    }
public ArbolAVL getArbolAVL(){
    return arbolAVL; }
}