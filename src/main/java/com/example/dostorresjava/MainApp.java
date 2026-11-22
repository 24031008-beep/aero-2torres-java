package com.example.dostorresjava;

import com.example.dostorresjava.config.FirebaseConfig;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApp extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FirebaseConfig.inicializar();
        FXMLLoader fxmlLoader = new FXMLLoader(MainApp.class.getResource("views/hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Aero-Torres");
        stage.setScene(scene);
        stage.show();
    }
}
