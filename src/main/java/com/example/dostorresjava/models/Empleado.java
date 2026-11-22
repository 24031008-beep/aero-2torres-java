package com.example.dostorresjava.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Empleado {

    private String id;

    private String numeroEmpleado;

    private String nombre;
    private String apellidos;

    private String correo;
    private String telefono;

    private String puesto;

    private String licencia;

    private Date fechaContratacion;

    private double salario;

    private boolean activo;

    private String turno;

    private String vueloAsignadoId;
}
