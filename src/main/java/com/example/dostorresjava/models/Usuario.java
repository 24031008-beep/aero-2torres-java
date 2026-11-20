package com.example.dostorresjava.models;


import java.util.HashMap;
import java.util.Map;

public class Usuario {

    private String uid;
    private String nombreCompleto;
    private String username;
    private String correo;
    private String telefono;
    private String rol;
    private boolean activo;

    private Map<String, Object> datosCliente = new HashMap<>();
    private Map<String, Object> datosEmpleado = new HashMap<>();

    public Map<String, Object> toMap() {

        Map<String, Object> map = new HashMap<>();

        map.put("uid", uid);
        map.put("nombre_completo", nombreCompleto);
        map.put("username", username);
        map.put("correo", correo);
        map.put("telefono", telefono);
        map.put("rol", rol);
        map.put("activo", activo);
        map.put("datos_cliente", datosCliente);
        map.put("datos_empleado", datosEmpleado);

        return map;
    }
}

