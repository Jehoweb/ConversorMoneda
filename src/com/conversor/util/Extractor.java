package com.conversor.util;

import com.conversor.interactiva.Terminal;
import com.conversor.modelo.MonedaEnum;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Extractor {

    public static StringBuilder [] seleccionDivisaComparativa(StringBuilder [] arrsbui){
        int tam = arrsbui.length;
        Random rndm = new Random();
        int idx = (tam-1);
        while(idx == (tam-1) && tam > 1 ){
            idx = (int)(rndm.nextDouble() * (tam-1) + 0);
        }
        if(idx < (tam-1)){
            StringBuilder aux = null;
            aux = new StringBuilder(arrsbui[tam-1].toString());
            arrsbui[tam-1].delete(0, arrsbui[tam-1].length());
            arrsbui[tam-1].append( arrsbui[idx].toString());
            arrsbui[idx].delete(0, arrsbui[tam-1].length());
            arrsbui[idx].append(aux.toString());
            aux = null;
        }
        return arrsbui;
    }

    public static StringBuilder [] seleccionClavesDivisas(List<MonedaEnum> lim){
        int iter = 0;
        StringBuilder [] arrsb = new StringBuilder[lim.size()];
        for(MonedaEnum me: lim){
            if(me != null) {
                arrsb[iter] = new StringBuilder();
                arrsb[iter].append(me.getCodigo());
                ++iter;
            }
        }
        return arrsb;
    }

    public static List<MonedaEnum> seleccionDivisasPorId(HashSet<Integer> lihs){
        List<MonedaEnum> arrDvsEnm = new ArrayList<>();
        lihs.forEach( (p)-> { arrDvsEnm.add(MonedaEnum.getMonedaPorId(p));  } );
        // System.out.println(" " +arrDvsEnm.stream().toList());
        lihs.clear();
        return arrDvsEnm;
    }

    public static void revisarArregloMoneda(){
        for(String a: Terminal.getMONEDA()){
            System.out.print(" "+ a.toString());
        }
        System.out.println();
    }

    public static  HashSet<Integer> seleccionAleatoriaNumerica(){
        int nDivisas =  MonedaEnum.getNumeroDivisas();
        HashSet<Integer> lihset = new HashSet<Integer>();
        Random rnd = new Random();
        while( Terminal.getNUMCODIGOS() - lihset.size() > 0 ){
            int p = (int)(rnd.nextDouble() * nDivisas + 1);
            lihset.add(p);
        }
        return lihset;
    }

    public static List<MonedaEnum> extraerDivisasPorClave(List<String> claves){
        List<MonedaEnum> arregloMoneda = new ArrayList<>();
        arregloMoneda =
                MonedaEnum.flujoDivisa()
                        .filter(divisa -> claves.contains(divisa.getCodigo()))
                        .collect(Collectors.toList());

        return arregloMoneda;
    }

    public static List<MonedaEnum> extraerDivisasPorId(List<Integer> ident){
        List<MonedaEnum> lisdivisa =
                MonedaEnum.flujoDivisa()
                        .filter(divisa -> ident.contains(divisa.getId()) )
                        .collect(Collectors.toList()) ;
        return lisdivisa;
    }



}
