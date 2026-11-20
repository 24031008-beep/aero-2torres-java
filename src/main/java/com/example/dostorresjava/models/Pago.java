package com.example.dostorresjava.models;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Pago {

    private String idPago;
    private String idReservacion;
    private String idUsuario;

    private String metodo;
    private String ultimosDigitos;

    private double monto;
    private String moneda;
    private String estado;

    private Date fechaPago;

    public Map<String, Object> toMap() {

        Map<String, Object> map = new HashMap<>();

        map.put("id_pago", idPago);
        map.put("id_reservacion", idReservacion);
        map.put("id_usuario", idUsuario);

        map.put("metodo", metodo);
        map.put("ultimos_digitos", ultimosDigitos);

        map.put("monto", monto);
        map.put("moneda", moneda);
        map.put("estado", estado);

        map.put("fecha_pago", fechaPago);

        return map;
    }
}

