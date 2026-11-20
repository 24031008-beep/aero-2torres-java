package com.example.dostorresjava.config;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

public class FirebaseConfig {
    private static Firestore db;

    public static synchronized void inicializar() throws IOException {

        FirebaseApp app;

        // Comprueba si Firebase ya está inicializado.
        List<FirebaseApp> aplicaciones = FirebaseApp.getApps();

        if (aplicaciones.isEmpty()) {

            String rutaCredenciales =
                    System.getenv("GOOGLE_APPLICATION_CREDENTIALS");

            if (rutaCredenciales == null
                    || rutaCredenciales.isBlank()) {

                throw new IllegalStateException(
                        "No se ha configurado la variable "
                                + "GOOGLE_APPLICATION_CREDENTIALS");
            }

            try (FileInputStream credenciales =
                         new FileInputStream(rutaCredenciales)) {

                FirebaseOptions opciones =
                        FirebaseOptions.builder()
                                .setCredentials(
                                        GoogleCredentials.fromStream(
                                                credenciales))
                                .build();

                app = FirebaseApp.initializeApp(opciones);
            }

        } else {
            // Reutiliza la instancia predeterminada.
            app = FirebaseApp.getInstance();
        }

        // Inicializa y guarda la conexión con Firestore.
        db = FirestoreClient.getFirestore(app);
    }

    public static Firestore getDB() {

        if (db == null) {
            throw new IllegalStateException(
                    "Debes inicializar Firebase antes de acceder "
                            + "a Firestore. Llama a FirebaseConfig.inicializar().");
        }

        return db;
    }
}
