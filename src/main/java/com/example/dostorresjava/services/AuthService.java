package com.example.dostorresjava.services;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;

public class AuthService {

    // Sustituye por la Web API Key de tu proyecto Firebase.
    private static final String API_KEY =
            "AIzaSyBN7HKH8sUJJtXCtZCqSoUnYLBdECL2uR8";

    private static final String BASE_URL =
            "https://identitytoolkit.googleapis.com/v1/accounts:";

    private final HttpClient http = HttpClient.newHttpClient();
    private final Gson gson = new Gson();

    public record Sesion(
            String uid,
            String nombre,
            String email,
            String idToken
    ) {}

    public Sesion registrar(
            String nombre,
            String email,
            String password)
            throws IOException, InterruptedException {

        JsonObject respuesta = post(
                "signUp",
                Map.of(
                        "email", email,
                        "password", password,
                        "returnSecureToken", true
                )
        );

        String uid = respuesta.get("localId").getAsString();
        String token = respuesta.get("idToken").getAsString();

        // Establecer el nombre visible en Firebase Authentication.
        JsonObject perfil = post(
                "update",
                Map.of(
                        "idToken", token,
                        "displayName", nombre,
                        "returnSecureToken", true
                )
        );

        String tokenActualizado =
                perfil.has("idToken")
                        ? perfil.get("idToken").getAsString()
                        : token;

        return new Sesion(uid, nombre, email, tokenActualizado);
    }

    public Sesion iniciarSesion(
            String email,
            String password)
            throws IOException, InterruptedException {

        JsonObject respuesta = post(
                "signInWithPassword",
                Map.of(
                        "email", email,
                        "password", password,
                        "returnSecureToken", true
                )
        );

        String uid = respuesta.get("localId").getAsString();

        String nombre = respuesta.has("displayName")
                && !respuesta.get("displayName").isJsonNull()
                ? respuesta.get("displayName").getAsString()
                : email;

        String token = respuesta.get("idToken").getAsString();

        return new Sesion(uid, nombre, email, token);
    }

    private JsonObject post(
            String operacion,
            Map<String, Object> datos)
            throws IOException, InterruptedException {

        String json = gson.toJson(datos);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(
                        BASE_URL + operacion + "?key=" + API_KEY))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(json))
                .build();

        HttpResponse<String> response = http.send(
                request,
                HttpResponse.BodyHandlers.ofString()
        );

        JsonObject resultado =
                JsonParser.parseString(response.body())
                        .getAsJsonObject();

        if (response.statusCode() < 200
                || response.statusCode() >= 300) {

            String mensaje = "No se pudo autenticar al usuario.";

            if (resultado.has("error")) {
                JsonObject error =
                        resultado.getAsJsonObject("error");

                if (error.has("message")) {
                    mensaje = error.get("message").getAsString();
                }
            }

            throw new IllegalArgumentException(mensaje);
        }

        return resultado;
    }
}


