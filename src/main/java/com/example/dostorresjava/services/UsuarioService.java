package com.example.dostorresjava.services;

import com.example.dostorresjava.config.FirebaseConfig;
import com.example.dostorresjava.models.Cliente;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.UserRecord.CreateRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ExecutionException;

public class UsuarioService {

    public String guardarCliente(Cliente cliente)
            throws ExecutionException, InterruptedException {

        Firestore db = FirebaseConfig.getDB();

        // Generar un identificador si no existe
        if (cliente.getIdClient() == null ||
                cliente.getIdClient().isBlank()) {
            cliente.setIdClient(UUID.randomUUID().toString());
        }

        // Preparar los datos
        Map<String, Object> datos = new HashMap<>();
        datos.put("UID", cliente.getIdClient());

        datos.put("name", cliente.getNombre());
        datos.put("lastName", cliente.getApellidos());
        datos.put("email", cliente.getCorreo());
        datos.put("phone", cliente.getTelefono());
        datos.put("passport", cliente.getPasaporte());
        datos.put("birthDate", cliente.getFechaNacimiento().toString());
        datos.put("nationality", cliente.getNacionalidad());
        datos.put("adress", cliente.getDireccion());
        datos.put("active", cliente.isActivo());
        datos.put("frecuent", cliente.isProgramaFrecuente());
        datos.put("frecuentId", cliente.getProgramaFrecuenteId());
        datos.put("preferences", cliente.getPreferencias());
        datos.put("registrationDate", cliente.getFechaNacimiento().toString());

        // Guardar en la colección clientes
        WriteResult resultado = db.collection("Client")
                .document(cliente.getIdClient())
                .set(datos)
                .get();

        System.out.println(
                "Cliente guardado: " + cliente.getIdClient()
        );

        return cliente.getIdClient();
    }

        public void guardarUsuario(String email, String password) throws FirebaseAuthException {

            CreateRequest request = new CreateRequest()
                    .setEmail(email)
                    .setPassword(password);
            FirebaseAuth auth = FirebaseAuth.getInstance();
            auth.createUser(request);
        }

}

