package com.example.dostorresjava.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaseAbordar {

    private String id;

    private String codigoAbordaje;

    private String clienteId;
    private String vueloId;
    private String reservacionId;

    private String asiento;

    private String puerta;

    private Date horaAbordaje;

    private Date fechaEmision;

    private String codigoQR;

    private String urlDocumento;

    //private EstadoPase estado;
}

