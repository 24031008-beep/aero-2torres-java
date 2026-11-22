package com.example.dostorresjava.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Ticket {

    private String id;

    private String codigoTicket;

    private String reservacionId;
    private String clienteId;
    private String vueloId;

    private String asientoId;

    private double precio;

    private Date fechaEmision;

    private String urlDocumento;

    //private EstadoTicket estado;
}
