package com.example.dostorresjava.models;

import java.util.HashMap;
import java.util.Map;

public class Equipaje {

    private String idEquipaje;
    private String idReservacion;

    private String tipo;

    private double pesoKg;
    private double cargoAdicional;

    private String estadoRetiro;

    public Map<String, Object> toMap() {

        Map<String, Object> map = new HashMap<>();

        map.put("id_equipaje", idEquipaje);
        map.put("id_reservacion", idReservacion);

        map.put("tipo", tipo);

        map.put("peso_kg", pesoKg);
        map.put("cargo_adicional", cargoAdicional);

        map.put("estado_retiro", estadoRetiro);

        return map;
    }
}

