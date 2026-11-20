package com.example.dostorresjava.models;

import java.util.HashMap;
import java.util.Map;

public class AeroNave {
    private String idAeronave;
    private String modelo;
    private int capacidadTotal;
    private String estado;

    private Map<String, Object> configuracionCabina =
            new HashMap<>();

    public Map<String, Object> toMap() {

        Map<String, Object> map = new HashMap<>();

        map.put("id_aeronave", idAeronave);
        map.put("modelo", modelo);
        map.put("capacidad_total", capacidadTotal);
        map.put("estado", estado);
        map.put("configuracion_cabina", configuracionCabina);

        return map;
    }
}
