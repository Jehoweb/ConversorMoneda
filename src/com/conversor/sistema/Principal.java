package com.conversor.sistema;
import com.conversor.excepcion.ErrorSoloNumerosException;
import com.conversor.interactiva.Terminal;
import com.conversor.modelo.ConversionMonetaria;
import com.conversor.modelo.MonedaEnum;
import com.conversor.modelo.TiposDeCambio;
import com.conversor.modelo.Historial;
import com.conversor.util.Archivo;
import com.conversor.util.Extractor;
import com.conversor.util.Tarea;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Principal {
    public static double cantidad = 0.0;
    public static double factor=0.0;
    public static double resultado=0.0;

    public static void aplicarSelecciones(){
        List<MonedaEnum> lisMoneda = new ArrayList<>();
        StringBuilder [] tux = Extractor.seleccionDivisaComparativa(
                Extractor.seleccionClavesDivisas(
                        lisMoneda =   Extractor.seleccionDivisasPorId(
                                Extractor.seleccionAleatoriaNumerica() ) ));
        Terminal.establecerMonedas(tux);

        Terminal.vaciarDIVISASET();
        for(String cod: Terminal.getMONEDA()){
            for(MonedaEnum m: lisMoneda){
                if(cod.equals(m.getCodigo())){
                   Terminal.setDIVISASET(m);
                }
            }
        }

    }

    public static void main (String [] args){
        LocalDateTime instante = null;
        List<Historial> historialUsuario = new ArrayList<>();
        DateTimeFormatter formaVisual = DateTimeFormatter.ofPattern("dd MMM uuuu', 'hh:mm a");
        StringBuilder salida = new StringBuilder();
        ApiMonedas monedaApi = new ApiMonedas();
        Scanner lector = new Scanner(System.in);
        String usuario=null;
        int terminoUno = -1 , terminoDos = -1;
        boolean seguir = true;
        int numdivisas = 0;
        int eleccion =0;

        usuario = Terminal.establecerUsuario();
        numdivisas = Terminal.establecerNumeroDeDivisas();
        eleccion = Terminal.establecerMetodoAPI();

        System.out.println();

        historialUsuario = Archivo.obtenHistorialDeUsuario(usuario);

        Principal.aplicarSelecciones();
        while(seguir) {
            Tarea.limpiarConsola();
            System.out.print(Terminal.formarMenu(usuario));
            int opc = lector.nextInt();
            if(opc==0) {
                seguir=false; //System.exit(0);
            }
            else {
                System.out.print(Terminal.formarEntrada());
                String numtxt = lector.next();

                    if( ! Tarea.esMontoValido(numtxt))     {
                        throw new ErrorSoloNumerosException("Solo se aceptan numeros");
                    } else {
                        cantidad = Double.valueOf(numtxt);
                    }

                if(opc % 2 != 0){
                    terminoUno= Terminal.getMONEDA().length-1;
                    terminoDos= ( (opc+1) /2)-1 ;
                } else {
                    terminoUno= (opc / 2)-1;
                    terminoDos = Terminal.getMONEDA().length-1;
                }

                if(eleccion==1){

                    System.out.print("\t\t\t\t\t+++ API primer metodo +++\n");
                    ConversionMonetaria cm = monedaApi.obtenConversionMonetaria( Terminal.getMONEDA(terminoUno), Terminal.getMONEDA(terminoDos) , cantidad);
                    //System.out.println(cm);
                    resultado = Double.valueOf(cm.conversion_result()); factor = Double.valueOf(cm.conversion_rate());

                    instante = LocalDateTime.now();
                    salida.append( cantidad+ "[" + cm.base_code() + "] "+ Terminal.obtenNombreMoneda(Terminal.getMONEDA(terminoUno))
                            + ", equivalen a " + cm.conversion_result() +"["+ cm.target_code()+"] "+ Terminal.obtenNombreMoneda(Terminal.getMONEDA(terminoDos))
                            + " '" + instante.format(formaVisual)+ "'" );

                }else if(eleccion == 2){

                    System.out.print("\t\t\t\t\t+++ API segundo metodo +++\n");
                    TiposDeCambio tc = monedaApi.obtenDeMonedaBaseTiposDeCambio(Terminal.getMONEDA(terminoUno));
                    // System.out.println(tc);

                    Map<String, Double> codtasa = tc.getClavesConTasa().obtenFactores();
                    factor = Tarea.extraerFactor(codtasa, Terminal.getMONEDA(terminoDos));
                    resultado = Tarea.hazConversion(cantidad, factor);
                    instante = LocalDateTime.now();
                    salida.append( cantidad+ "[" + tc.getCodigoBase() + "] "
                            + Terminal.obtenNombreMoneda(Terminal.getMONEDA(terminoUno)) + ", equivalen a "
                            + resultado +"["+ Terminal.getMONEDA(terminoDos)+"] " + Terminal.obtenNombreMoneda(Terminal.getMONEDA(terminoDos))
                            + " '" + instante.format(formaVisual)+ "'");

                }

                Historial historico = new Historial(usuario,factor, cantidad, Terminal.getMONEDA(terminoUno), resultado, Terminal.getMONEDA(terminoDos), instante);

                Archivo.escribirHistorialDeUsuario(historico);

                historialUsuario.add(historico);
                System.out.println(salida.toString());
                salida.delete(0, salida.length());
                cantidad = 0.0; factor=0.0; resultado=0.0;

                if(historialUsuario.size()>1){
                    Terminal.verMenuDeConversionesRealizadas( historialUsuario);
                }

                System.out.println("¿Desea regresar al Menu Principal? (S) o (N):");
                char resp = lector.next().charAt(0);
                resp = Character.toUpperCase(resp);

                if(resp == 'N'){
                    seguir = false;
                }
                //IllegalArgumentException  RuntimeException
            }
        }

    }


}
