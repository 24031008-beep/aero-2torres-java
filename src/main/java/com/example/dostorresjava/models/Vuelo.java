package com.example.dostorresjava.models;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Vuelo {

    private String id;
    private String codigoVuelo;

    private String origen;
    private String destino;

    private Date fechaSalida;
    private Date fechaLlegada;

    private String aeronaveId;

    private double precio;

    private int capacidad;
    private int asientosDisponibles;

    //private EstadoVuelo estado;

    private Date fechaCreacion;
}