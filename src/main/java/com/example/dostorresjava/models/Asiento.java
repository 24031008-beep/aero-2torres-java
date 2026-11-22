package com.example.dostorresjava.models;

import com.example.dostorresjava.enums.EstadoAsiento;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Asiento {

    private String id;

    private String codigo;
    private String aeronaveId;
    private String vueloId;

    private int fila;
    private String columna;

    private String clase;

    private EstadoAsiento estado;

    private double precioAdicional;
}
