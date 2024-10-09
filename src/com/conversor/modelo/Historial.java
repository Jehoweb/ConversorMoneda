package com.conversor.modelo;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Historial {
    private String usuario;
    private Double tasa;
    private Double cantidad;
    private String monedaOrigen;
    private Double conversion;
    private String monedaDestino;
    private LocalDateTime fechaHora;

    public Historial(String usuario, Double tasa, Double cantidad, String monedaOrigen,
                     Double conversion, String monedaDestino, LocalDateTime fechaHora){
        this.usuario=usuario;
        this.tasa=tasa;
        this.cantidad=cantidad;
        this.monedaOrigen=monedaOrigen;
        this.conversion=conversion;
        this.monedaDestino=monedaDestino;
        this.fechaHora=fechaHora;
    }

    public String hazLineaTextual() {
        DateTimeFormatter formaGuardar = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        StringBuilder sb = new StringBuilder();
        sb.append(getUsuario()+"|");
        sb.append(getTasa()+"|");
        sb.append(getMonedaOrigen()+"|");
        sb.append(getCantidad()+"|");
        sb.append(getMonedaDestino()+"|");
        sb.append(getConversion()+"|");
        sb.append(getFechaHora().format(formaGuardar)+"|");
        return sb.toString();
    }

    public String hazLineaTextualConsola() {
        DateTimeFormatter formaVisual = DateTimeFormatter.ofPattern("dd MMM uuuu', 'hh:mm a");
        DecimalFormat df = new DecimalFormat("#,###,###.00#");
        DecimalFormat decf = new DecimalFormat("#,###,###.##");
        StringBuilder sb = new StringBuilder();
        sb.append(getUsuario() + "\t\t");
        sb.append("tipo de cambio:"+getTasa() + "     ");
        sb.append(decf.format(getCantidad())+" ");
        sb.append("["+getMonedaOrigen()+"] = ");
        sb.append(df.format(getConversion())+" ");
        sb.append("["+getMonedaDestino() +"]     ");
        sb.append("\""+getFechaHora().format(formaVisual)+"\"");
        return sb.toString();
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public Double getTasa() {
        return tasa;
    }

    public void setTasa(Double tasa) {
        this.tasa = tasa;
    }

    public Double getCantidad() {
        return cantidad;
    }

    public void setCantidad(Double cantidad) {
        this.cantidad = cantidad;
    }

    public String getMonedaOrigen() {
        return monedaOrigen;
    }

    public void setMonedaOrigen(String monedaOrigen) {
        this.monedaOrigen = monedaOrigen;
    }

    public Double getConversion() {
        return conversion;
    }

    public void setConversion(Double conversion) {
        this.conversion = conversion;
    }

    public String getMonedaDestino() {
        return monedaDestino;
    }

    public void setMonedaDestino(String monedaDestino) {
        this.monedaDestino = monedaDestino;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }
}
