package com.example.dostorresjava.controllers;

import com.example.dostorresjava.MainApp;
import com.example.dostorresjava.enums.NivelFrecuente;
import com.example.dostorresjava.models.Cliente;
import com.example.dostorresjava.services.ClienteService;
import com.example.dostorresjava.services.UsuarioService;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.time.LocalDate;
import java.util.Date;
import java.util.ResourceBundle;

public class SignInController implements Initializable {
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
    @FXML
    protected void onAddButtonClick() {
        registrarCliente();
        try {
            Stage stage = (Stage) btnSend.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("views/hello-view.fxml"));
            Scene scene = new Scene(loader.load(), 380, 480);
            stage.setTitle("Sign In");
            stage.setScene(scene);
            stage.centerOnScreen();
            stage.show();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @FXML
    private Button btnSend;
    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtCorreo;

    @FXML
    private PasswordField txtPassword;
    @FXML
    private PasswordField confirmPassword;
    @FXML
    private TextField txtApellido;
    @FXML
    private TextField txtTelefono;
    @FXML
    private TextField txtPasaporte;
    @FXML
    private TextField txtFechaNac;
    @FXML
    private TextField txtNacionalidad;
    @FXML
    private TextField txtAdress;

    @FXML
    private void registrarCliente() {

        String id = java.util.UUID.randomUUID().toString();

        UsuarioService servicio = new UsuarioService();

        javafx.concurrent.Task<Void> tarea =
                new javafx.concurrent.Task<>() {
                    @Override
                    protected Void call() throws Exception {
                        if(txtPassword.getText().equals(confirmPassword.getText()) && !txtNombre.getText().isEmpty()
                                && !txtApellido.getText().isEmpty() && !txtTelefono.getText().isEmpty()
                                && !txtCorreo.getText().isEmpty()) {
                            //configurar en la vista
                            servicio.guardarCliente( new Cliente(
                                    id,
                                    "",
                                    txtNombre.getText(),
                                    txtApellido.getText(),
                                    txtCorreo.getText(),
                                    txtTelefono.getText(),
                                    txtPasaporte.getText(),
                                    LocalDate.parse(txtFechaNac.getText()),
                                    txtNacionalidad.getText(),
                                    txtAdress.getText(),
                                    true,
                                    true,
                                    "N/A",
                                    NivelFrecuente.BRONCE,
                                    LocalDate.now(),
                                    txtPassword.getText())
                            );
                            servicio.guardarUsuario(txtCorreo.getText(), txtPassword.getText());
                        }
                        else {
                            txtNombre.clear();
                            txtApellido.clear();
                            txtCorreo.clear();
                            txtTelefono.clear();
                            txtPassword.clear();
                            confirmPassword.clear();
                            System.out.println("Revisa los parámetro que insertaste");
                        }
                        return null;
                    }
                };

        tarea.setOnSucceeded(event -> {
            System.out.println("Registro completado");
        });

        tarea.setOnFailed(event -> {
            tarea.getException().printStackTrace();
        });

        Thread hilo = new Thread(tarea);
        hilo.setDaemon(true);
        hilo.start();
    }
}
