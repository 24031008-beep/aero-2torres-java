package com.example.dostorresjava.models;

import com.example.dostorresjava.enums.NivelFrecuente;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Cliente {

    private String id;
    private String uid;
    private String nombre;
    private String apellidos;
    private String correo;
    private String telefono;
    private String pasaporte;
    private LocalDate fechaNacimiento;
    private String nacionalidad;
    private String direccion;
    private boolean activo;
    private boolean programaFrecuente;
    private String programaFrecuenteId;
    private NivelFrecuente preferencias;
    private LocalDate fechaRegistro;
    private String password;

    public String getIdClient() {
        return id;
    }

    public void setIdClient(String string) {
        this.id = string;
    }
}
