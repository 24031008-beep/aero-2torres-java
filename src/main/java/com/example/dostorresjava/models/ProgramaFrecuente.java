package com.example.dostorresjava.models;

import com.example.dostorresjava.enums.NivelFrecuente;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProgramaFrecuente {

    private String id;

    private String clienteId;

    private int puntos;

    private int puntosAcumulados;

    private int puntosUtilizados;

    private NivelFrecuente nivel;

    private Date fechaInscripcion;

    private Date ultimaActualizacion;

    private boolean activo;
}
