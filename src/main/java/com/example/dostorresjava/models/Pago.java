package com.example.dostorresjava.models;


import com.example.dostorresjava.enums.EstadoPago;
import com.example.dostorresjava.enums.MetodoPago;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pago {

    private String id;

    private String reservacionId;
    private String clienteId;

    private double monto;

    private MetodoPago metodo;

    private EstadoPago estado;

    private Date fecha;

    private String referencia;

    private String descripcion;

    private double montoReembolsado;
}