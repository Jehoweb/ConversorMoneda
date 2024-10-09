package com.conversor.modelo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TiposDeCambio {
    @SerializedName("result")
    @Expose
    private String resultado;
    @SerializedName("time_next_update_utc")
    @Expose
    private String fechaSigUTC;
    @SerializedName("base_code")
    @Expose
    private String codigoBase;
    @SerializedName("conversion_rates")
    @Expose
    private ClavesConFactor clavesConTasa;



    public TiposDeCambio(String result, String fecha, String cod, ClavesConFactor tasa ){
        this.resultado=result;
        this.fechaSigUTC=fecha;
        this.codigoBase=cod;
        this.clavesConTasa=tasa;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public String getFechaSigUTC() {
        return fechaSigUTC;
    }

    public void setFechaSigUTC(String fechaSigUTC) {
        this.fechaSigUTC = fechaSigUTC;
    }

    public String getCodigoBase() {
        return codigoBase;
    }

    public void setCodigoBase(String codigoBase) {
        this.codigoBase = codigoBase;
    }

    public ClavesConFactor getClavesConTasa() {
        return clavesConTasa;
    }

    public void setClavesConTasa(ClavesConFactor clavesConTasa) {
        this.clavesConTasa = clavesConTasa;
    }

    @Override
    public String toString(){
        return  "[ Resultado = '" + resultado + '\'' +
                "  Fecha = " + fechaSigUTC +
                "  Codigo Base = <" + codigoBase+ ">"+
                "  Tasas = { \n"+ clavesConTasa.toString() +
                "} \n]";
    }



}
