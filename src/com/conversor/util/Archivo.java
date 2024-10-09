package com.conversor.util;

import com.conversor.modelo.Historial;
import com.sun.tools.javac.Main;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Archivo {

    public static List<Historial> obtenHistorialDeUsuario(String usuario){
        String rutaDelArchivo = "historial.txt";
        List<Historial> histUsu = new ArrayList<>();
        try (FileReader leeArchivo = new FileReader(rutaDelArchivo);
             BufferedReader buferLector = new BufferedReader(leeArchivo)) {
            String linea;
            while ((linea = buferLector.readLine()) != null) {
                int idx= linea.indexOf('|');
                //System.out.println(linea.substring(0, idx));
                if(linea.substring(0, idx).equalsIgnoreCase(usuario)){
                    Historial h = Tarea.generarHistorialApartirDeLinea(linea);
                    histUsu.add(h);
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer archivo: " + e.getMessage());
        }
        return histUsu;
    }

    public static void escribirHistorialDeUsuario(Historial movimiento){
        try( FileWriter fw = new FileWriter(new File("historial.txt").getAbsoluteFile(), true) ){
            fw.write(movimiento.hazLineaTextual()+ "\n");
        } catch (IOException ex){
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
