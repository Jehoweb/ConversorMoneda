package com.conversor.sistema;

import com.conversor.modelo.ConversionMonetaria;
import com.conversor.modelo.TiposDeCambio;
import com.google.gson.Gson;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiMonedas {
    public final String APIKey="2fa840a0122d5900908aaa41";

    public ConversionMonetaria obtenConversionMonetaria(String claveMonedaBase, String claveMonedaDestino, double monto)  {
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/"+APIKey +"/pair/"+claveMonedaBase +"/"+claveMonedaDestino+"/"+ monto);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();
        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), ConversionMonetaria.class);
        } catch (Exception e) {
           throw new RuntimeException("No encontre esa Divisa: " +e.getMessage());

        }
   }

    public TiposDeCambio obtenDeMonedaBaseTiposDeCambio(String claveMonedaBase)  {
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/"+ APIKey +"/latest/"+claveMonedaBase);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), TiposDeCambio.class);
        } catch (Exception e) {
            throw new RuntimeException("No encontre esa UltimaDivisa: " +e.getMessage());

        }
    }


}
