package com.example.dostorresjava.models;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class NominaTurno {

    private String idRegistro;
    private String idEmpleado;

    private Date fecha;

    private String horaEntrada;
    private String horaSalida;

    private double horasTrabajadas;
    private double montoPagado;

    private String estadoPago;

    public Map<String, Object> toMap() {

        Map<String, Object> map = new HashMap<>();

        map.put("id_registro", idRegistro);
        map.put("id_empleado", idEmpleado);

        map.put("fecha", fecha);

        map.put("hora_entrada", horaEntrada);
        map.put("hora_salida", horaSalida);

        map.put("horas_trabajadas", horasTrabajadas);
        map.put("monto_pagado", montoPagado);

        map.put("estado_pago", estadoPago);

        return map;
    }
}

