package com.conversor.api;

import com.google.gson.Gson;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiClient {

    private static final String API_KEY = "4c2b47f9919c0dc9428f667d";
    private static final String API_BASE_URL = "https://v6.exchangerate-api.com/v6/";

    private HttpClient httpClient;
    private Gson gson;

    public ApiClient() {
        this.httpClient = HttpClient.newHttpClient();
        this.gson = new Gson();
    }

    public ApiResponse getPairConversion(String moneda1, String moneda2, double cant) {

        String url = API_BASE_URL + API_KEY + "/pair/" + moneda1 + "/" + moneda2 + "/" + cant;

        try {
            // Crear request
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI(url))
                    .GET()
                    .build();

            // Enviar solicitud y obtener response
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            // Verificar respuesta
            if (response.statusCode() != 200) {
                System.err.println("Error al contactar la API: Código " + response.statusCode());
                System.err.println("Respuesta: " + response.body());
                return null;
            }

            // Convertir el JSON
            String jsonResponse = response.body();
            ApiResponse apiResponse = gson.fromJson(jsonResponse, ApiResponse.class);

            if (!"success".equals(apiResponse.getResult())) {
                System.err.println("La API reportó un error: " + jsonResponse);
                return null;
            }

            return apiResponse;

        } catch (Exception e) {
            System.err.println("Ha ocurrido una excepción: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
}