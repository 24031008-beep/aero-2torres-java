package com.example.dostorresjava.models;

import com.example.dostorresjava.enums.EstadoEquipaje;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Equipaje {

    private String id;

    private String reservacionId;
    private String clienteId;
    private String vueloId;

    private String etiqueta;

    private double peso;

    private String tipo;

    private double cargoAdicional;

    private EstadoEquipaje estado;

    private Date fechaRegistro;
}