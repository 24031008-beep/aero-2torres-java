package com.example.dostorresjava.models;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class PaseAbordar {

    private String idPase;
    private String idReservacion;

    private String grupoAbordaje;
    private String codigoQr;
    private String estadoCheckin;

    private Date fechaEmision;

    public Map<String, Object> toMap() {

        Map<String, Object> map = new HashMap<>();

        map.put("id_pase", idPase);
        map.put("id_reservacion", idReservacion);

        map.put("grupo_abordaje", grupoAbordaje);
        map.put("codigo_qr", codigoQr);
        map.put("estado_checkin", estadoCheckin);

        map.put("fecha_emision", fechaEmision);

        return map;
    }
}

