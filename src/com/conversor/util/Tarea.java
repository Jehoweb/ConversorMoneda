package com.conversor.util;

import com.conversor.modelo.Historial;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

public class Tarea {

    public static void limpiarConsola(){
        try {
            String so = System.getProperty("os.name");
            if (so.contains("Windows")) {
                new ProcessBuilder("cmd", "cls /c", "exit").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e) {
            System.out.println("Excepcion: " +e.getMessage());
        }
    }

    public static double hazConversion(double cantidad, double factor){
        BigDecimal cant = new BigDecimal(cantidad);
        BigDecimal fact = new BigDecimal(factor);
        BigDecimal rslt = fact.multiply(cant);

        return (rslt.doubleValue());
    }

    public static double extraerFactor (Map<String, Double> codigoValorTasas, String codigoTasa){
        double tasa=0.0;
        for (Map.Entry<String, Double> sd : codigoValorTasas.entrySet()) {
            if(sd.getKey().equals(codigoTasa)) {
                tasa = sd.getValue().doubleValue();
                break;
            }
        }
        return tasa;
    }


    public static Historial generarHistorialApartirDeLinea(String linea){
        DateTimeFormatter formaFecha = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter formaHora = DateTimeFormatter.ofPattern("HH:mm");
        String usu=""; Double tz=0.0; Double cant=0.0; String mndOrg="";
        Double conv=0.0; String mndDst=""; LocalDateTime fchHr=null;
        Historial hist = null;
        int idx= -1; int a=0; int ciclo=1;
        while ((idx = linea.indexOf('|', idx + 1)) != -1) {
            //System.out.println("pos: " + linea.substring(a, idx));
            switch (ciclo){
                case 1: usu = (linea.substring(a, idx));
                    break;
                case 2: tz= (Double.valueOf(linea.substring(a, idx)));
                    break;
                case 3: mndOrg = (linea.substring(a, idx));
                    break;
                case 4: cant= (Double.valueOf(linea.substring(a, idx)));
                    break;
                case 5: mndDst = (linea.substring(a, idx));
                    break;
                case 6: conv = (Double.valueOf(linea.substring(a, idx)));
                    break;
                case 7: LocalDate lFch = LocalDate.parse(linea.substring(a, idx).substring(0, 10), formaFecha);
                    LocalTime lHra  = LocalTime.parse(linea.substring(a, idx).substring(11,16), formaHora);
                    fchHr = LocalDateTime.of(lFch, lHra);
                    break;
                default : break;
            }
            ++ciclo;
            a=idx+1;
        }
        hist = new Historial(usu, tz, cant, mndOrg, conv, mndDst, fchHr);
        return hist;
    }

    public static boolean esMontoValido(String digitos) {
        return digitos.matches("^[0-9]+(\\.[0-9]+){0,1}");
    }

}
