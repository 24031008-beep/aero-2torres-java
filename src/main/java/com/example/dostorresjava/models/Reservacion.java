package com.example.dostorresjava.models;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Reservacion {

    private String idReservacion;
    private String codigoReserva;
    private String idUsuario;
    private String idVuelo;

    private String pasajeroNombre;
    private String asiento;
    private String zonaAsiento;
    private String tarifaSeleccionada;

    private double totalPagado;
    private String metodo;

    private Date fechaReserva;
    private boolean correoEnviado;

    private Map<String, Object> cancelacion = new HashMap<>();

    public Map<String, Object> toMap() {

        Map<String, Object> map = new HashMap<>();

        map.put("id_reservacion", idReservacion);
        map.put("codigo_reserva", codigoReserva);
        map.put("id_usuario", idUsuario);
        map.put("id_vuelo", idVuelo);

        map.put("pasajero_nombre", pasajeroNombre);
        map.put("asiento", asiento);
        map.put("zona_asiento", zonaAsiento);
        map.put("tarifa_seleccionada", tarifaSeleccionada);

        map.put("total_pagado", totalPagado);
        map.put("metodo", metodo);

        map.put("fecha_reserva", fechaReserva);
        map.put("correo_enviado", correoEnviado);
        map.put("cancelacion", cancelacion);

        return map;
    }
}

