package com.example.dostorresjava.controllers;

import com.example.dostorresjava.MainApp;
import com.example.dostorresjava.services.AuthService;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {

    @FXML
    private TextField txtCorreo;
    @FXML
    private PasswordField txtPassword;
    @FXML
    private Label lblMensaje;
    @FXML
    private Button btnEntrar;


    @FXML
    protected void onLooginButtonClick() {
        iniciarSesion();
    }
    @FXML
    protected void onAddButtonClick() {
        try {
            Stage stage = (Stage) btnEntrar.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("views/signin.fxml"));
            Scene scene = new Scene(loader.load(), 380, 750);
            stage.setTitle("Customer Manager");
            stage.setScene(scene);
            stage.centerOnScreen();
            stage.show();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private final AuthService authService = new AuthService();

    @FXML
    private void iniciarSesion() {
        String correo = txtCorreo.getText().trim();
        String password = txtPassword.getText();

        if (correo.isBlank() || password.isBlank()) {
            lblMensaje.setText("Ingresa tu correo y contraseña.");
            return;
        }

        btnEntrar.setDisable(true);
        lblMensaje.setText("Verificando credenciales...");

        Task<AuthService.Sesion> tarea = new Task<>() {
            @Override
            protected AuthService.Sesion call() throws Exception {
                return authService.iniciarSesion(correo, password);
            }
        };

        tarea.setOnSucceeded(event -> {
            btnEntrar.setDisable(false);

            AuthService.Sesion sesion = tarea.getValue();

            try {
                FXMLLoader loader = new FXMLLoader(
                        MainApp.class.getResource("views/clientes.fxml")
                );

                Parent vista = loader.load();

                ClienteController controlador =
                        loader.getController();

                controlador.setSesion(sesion);

                Stage ventana = (Stage) btnEntrar
                        .getScene().getWindow();

                ventana.setScene(new Scene(vista));
                ventana.setMaximized(true);
                ventana.setTitle("Clientes");
            } catch (IOException e) {
                lblMensaje.setText(
                        "No se pudo abrir el tablero."
                );
                e.printStackTrace();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });

        tarea.setOnFailed(event -> {
            btnEntrar.setDisable(false);
            lblMensaje.setText(
                    "No se pudo iniciar sesión. Revisa tus datos."
            );
            tarea.getException().printStackTrace();
        });

        Thread hilo = new Thread(tarea);
        hilo.setDaemon(true);
        hilo.start();
    }
}
