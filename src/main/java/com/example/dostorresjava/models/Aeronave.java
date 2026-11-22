package com.example.dostorresjava.models;


import com.example.dostorresjava.enums.EstadoAeronave;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Aeronave {

    private String id;

    private String matricula;
    private String modelo;
    private String fabricante;

    private int capacidad;
    private int filas;
    private int asientosPorFila;

    private EstadoAeronave estado;

    private String descripcion;
}
