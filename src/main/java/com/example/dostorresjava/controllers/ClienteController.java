package com.example.dostorresjava.controllers;

import com.example.dostorresjava.services.AuthService;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class ClienteController {
    @FXML
    private Label lblBienvenida;
    private AuthService.Sesion sesion;

    public void setSesion(AuthService.Sesion sesion) throws Exception {

        this.sesion = sesion;

        lblBienvenida.setText(
                "Bienvenido, " + sesion.nombre());
    }
}
