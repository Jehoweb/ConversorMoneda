package com.conversor.interactiva;

import com.conversor.modelo.Historial;
import com.conversor.modelo.MonedaEnum;
import com.conversor.util.Tarea;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Terminal {
    public static  int NUMCODIGOS = 5;
    public static String [] MONEDA = {"ARS", "BRL", "COP", "MXN", "USD"};
    public static EnumSet<MonedaEnum> DIVISASET = EnumSet.of(MonedaEnum.ARS, MonedaEnum.BRL, MonedaEnum.COP, MonedaEnum.MXN, MonedaEnum.USD  );

    public static void vaciarDIVISASET(){
        DIVISASET.clear();
    }

    public static void setDIVISASET(MonedaEnum enumdivisa){
        DIVISASET.add(enumdivisa);
    }

    public static String getMONEDA(int idx){
        return MONEDA[idx];
    }
    public static String [] getMONEDA(){
        return MONEDA;
    }

    public static void setMONEDA(int tam){
        MONEDA = new String[tam];
    }

    public static void setMONEDA(int idx, String cont){
        MONEDA[idx]= cont;
    }

    public static int getNUMCODIGOS(){
        return NUMCODIGOS;
    }

    public static void setNUMCODIGOS(int ncod){
        NUMCODIGOS = ncod;
    }

    public static void establecerMonedas(StringBuilder [] arrsb){
        Terminal.setMONEDA(arrsb.length);
        for(int idx=0; idx < arrsb.length; idx++){
            Terminal.setMONEDA(idx, arrsb[idx].toString());
        }
    }

    public static String obtenNombreMoneda(String clave){
        Iterator<MonedaEnum> iterar = DIVISASET.iterator();
        MonedaEnum divEnum = null; String nom="";
        while(iterar.hasNext()) {
            divEnum = iterar.next();
            if(divEnum.getCodigo().equals(clave)){
                nom = divEnum.getNombre();
                break;
            }
        }
        return nom;
    }

    public static String establecerUsuario(){
        String usua ="";
        Scanner lee = new Scanner(System.in);
        while(usua.length() == 0){
             Tarea.limpiarConsola();
             System.out.print("Escriba su Nombre: " );
             usua = lee.nextLine();
        }
        return usua;
    }

    public static int establecerNumeroDeDivisas(){
        Scanner lee = new Scanner(System.in);
        int numdivisas=0;
        while(numdivisas < 2){
            System.out.print("¿Indique cuantas monedas estaran en el conversor de monedas? : ");
            numdivisas = Integer.parseInt( lee.nextLine() );
            Terminal.setNUMCODIGOS(numdivisas);
            Tarea.limpiarConsola();
        }
        return numdivisas;
    }

    public static int establecerMetodoAPI(){
        int tipo =0; Scanner lee = new Scanner(System.in);
        while(tipo != 1 && tipo != 2 ){
            System.out.println("1. API genera todo el proceso de conversion");
            System.out.println("2. API obtiene los tipos de cambio y los calculos el sistema local");
            System.out.print("Ingrese su eleccion (1) o (2): ");
            tipo  = Integer.parseInt( lee.nextLine() );
            Tarea.limpiarConsola();
        }
        return tipo;
    }

    public static StringBuilder formarMenu(String nombre){
        StringBuilder menu = new StringBuilder();
        int ren=1; int ult= (NUMCODIGOS-1)*2;  int k=0;
        menu.append("************************************************\n");
        menu.append(centrarTexto(nombre).toString());
        menu.append("*     Bienvenida(o) al Conversor de Moneda     *\n");
        //menu.append("*              Autor: JEHOVANY                 *\n");

        menu.append("************************************************\n");
        for (int i = 0; i < ult; i++) {
            if(ren % 2 != 0){
                //menu.append("*             "+ren+" )    "+MONEDA[MONEDA.length-1]+"  =>>  "+MONEDA[k]+"             *\n");
                menu.append( centrarTexto(ren+" )    "+MONEDA[MONEDA.length-1]+"  =>>  "+MONEDA[k]) );
            } else {
                //menu.append("*             "+ren+" )    "+MONEDA[k]+"  =>>  "+MONEDA[MONEDA.length-1]+"             *\n");
                menu.append( centrarTexto(ren+" )    "+MONEDA[k]+"  =>>  "+MONEDA[MONEDA.length-1]) );
                ++k;
            }
            ++ren;
        }
        menu.append("*             0 )    S a l i r                 *\n");
        menu.append("************************************************\n");
        menu.append("De favor elija una opción: ");
        return menu;
    }

    public static StringBuilder formarEntrada(){
        return new StringBuilder("Capture la cantidad a convertir: ");
    }

    public static StringBuilder centrarTexto(String txt){
        StringBuilder bu = new StringBuilder();
        int espDispon= 48 - 2 - txt.length();
        int izq=0, der=0;
        if(espDispon % 2 ==0){
            izq=espDispon/2;
            der=izq;
        } else {
            izq=espDispon/2;
            der= (izq +1);
        }
        espDispon= 48;
        for (int i = 0; i < espDispon; i++) {
            if(i==0 || i == espDispon-1){
                bu.append("*");
            }else if(izq>0){
                bu.append(' ');
                --izq;
            }else if(izq == 0){
                bu.append(txt);
                i = i + txt.length()-1;
                izq=-1;
            }else if(der > 0){
                bu.append(" ");
                --der;
            }
        }
        bu.append("\n");
        return bu;
    }


    public static void verMenuDeConversionesRealizadas( List<Historial> liHist) {
        Scanner leer = new Scanner(System.in);
        StringBuilder creaMn = new StringBuilder();
        creaMn.append("-----------------------------------------------------\n");
        creaMn.append( "|      Historial de las Conversiones Realizadas     |\n");
        creaMn.append( "|---------------------------------------------------|\n" );
        creaMn.append( "|           { T }  Todas                            |\n" );
        creaMn.append( "|           { F }  Por Fecha                        |\n" );
        creaMn.append( "|           { D }  Por Divisa                       |\n" );
        creaMn.append( "|           { M }  Desde un Monto Origen            |\n" );
        creaMn.append( "|           { 0 }  S A L I R                        |\n");
        creaMn.append( "-----------------------------------------------------\n");
        creaMn.append( "Elija con la letra la opcion deseada: ");
        System.out.print(" ¿Desea ver las conversiones realizadas? (S) o (N): ");
        char v = Character.toUpperCase( leer.nextLine().charAt(0) ); boolean repetir=true;
        if(v == 'S'){
            while( repetir ){
                Tarea.limpiarConsola();
                System.out.print(creaMn.toString());
                char ltr = Character.toUpperCase( leer.next().charAt(0) );
                if(ltr == 'T'){
                    for (int i=0;i<liHist.size();i++) {
                        System.out.println(liHist.get(i).hazLineaTextualConsola());
                    }
                } else if(ltr == 'F'){
                    DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                    LocalDate fechaUno = null;
                    LocalDate fechaDos = null;
                    System.out.print("Escriba la fecha en el formato yyyy-mm-dd : ");
                    String fechax = leer.next().toString();
                    fechaUno = LocalDate.parse(fechax, formato);
                    for (int i=0; i<liHist.size(); i++) {
                        fechaDos = liHist.get(i).getFechaHora().toLocalDate();
                        if(fechaUno.isEqual(fechaDos)){
                            //System.out.println( "Fecha 1 es "+fechaUno+" igual a "+fechaDos );
                            System.out.println(liHist.get(i).hazLineaTextualConsola());
                        }else if(fechaUno.isAfter(fechaDos)){
                            //System.out.println( "Fecha 1 "+ fechaUno+" es mayor a " +fechaDos );
                        }else if(fechaUno.isBefore(fechaDos)){
                            //System.out.println( "Fecha 1 "+fechaUno+" es menor a " +fechaDos );
                        }
                    }

                }else if(ltr == 'D'){
                    System.out.print("Escriba la divisa en fomato XXX ej. USD : ");
                    String dvs = leer.next().toString();
                    for (int i=0; i<liHist.size(); i++) {
                        if( liHist.get(i).getMonedaOrigen().equals(dvs) ||
                                liHist.get(i).getMonedaDestino().equals(dvs) ){
                            System.out.println(liHist.get(i).hazLineaTextualConsola());
                        }
                    }
                }else if(ltr == 'M'){
                    System.out.print("Escriba apartir de que monto origen a mostrar : ");
                    double cant = leer.nextDouble();
                    for (int i=0; i < liHist.size(); i++) {
                        if(liHist.get(i).getCantidad() >= cant){
                            System.out.println(liHist.get(i).hazLineaTextualConsola());
                        }
                    }
                } else if(ltr == '0'){
                    repetir = false;
                }

                if( repetir ){
                    System.out.print("¿Desea hacer otra busqueda en el Historial de Conversiones? (S) o (N): ");
                    v = Character.toUpperCase( leer.next().charAt(0) );
                    repetir = (v != 'S') ? false: true;
                }


            }
        }
    }

}
