package com.example.dostorresjava.models;

import com.example.dostorresjava.enums.EstadoCheckIn;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CheckIn {

    private String id;

    private String reservacionId;
    private String clienteId;
    private String vueloId;

    private Date fechaCheckIn;

    private boolean completado;

    private String asientoId;

    private String paseAbordarId;

    private EstadoCheckIn estado;
}