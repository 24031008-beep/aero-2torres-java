package com.example.dostorresjava.models;

import com.example.dostorresjava.enums.EstadoReservacion;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Reservacion {

    private String id;

    private String codigoReservacion;

    private String clienteId;
    private String vueloId;

    private List<String> asientos;

    private Date fechaReservacion;

    private int cantidadPasajeros;

    private double precioTotal;

    private EstadoReservacion estado;

    private String pagoId;

    private String ticketId;
}