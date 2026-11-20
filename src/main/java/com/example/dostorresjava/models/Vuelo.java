package com.example.dostorresjava.models;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Vuelo {
    private String idVuelo;
    private String numeroVuelo;
    private String idAeronave;

    private Map<String, Object> origen = new HashMap<>();
    private Map<String, Object> destino = new HashMap<>();

    private Date fechaSalida;
    private Date fechaLlegada;

    private int duracionMin;
    private double distanciaKm;

    private String puerta;
    private String horaEmbarque;
    private String climaPuerta;
    private String estado;

    private Map<String, Object> tarifas = new HashMap<>();

    private List<String> tripulacionIds = new ArrayList<>();
    private List<String> asientosOcupados = new ArrayList<>();

    public Map<String, Object> toMap() {

        Map<String, Object> map = new HashMap<>();

        map.put("id_vuelo", idVuelo);
        map.put("numero_vuelo", numeroVuelo);
        map.put("id_aeronave", idAeronave);

        map.put("origen", origen);
        map.put("destino", destino);

        map.put("fecha_salida", fechaSalida);
        map.put("fecha_llegada", fechaLlegada);

        map.put("duracion_min", duracionMin);
        map.put("distancia_km", distanciaKm);

        map.put("puerta", puerta);
        map.put("hora_embarque", horaEmbarque);
        map.put("clima_puerta", climaPuerta);
        map.put("estado", estado);

        map.put("tarifas", tarifas);
        map.put("tripulacion_ids", tripulacionIds);
        map.put("asientos_ocupados", asientosOcupados);

        return map;
    }

}
