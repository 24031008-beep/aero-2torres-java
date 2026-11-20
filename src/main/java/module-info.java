module com.example.dostorresjava {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.ikonli.javafx;
    requires firebase.admin;
    requires google.cloud.firestore;
    requires com.google.auth.oauth2;
    requires com.google.gson;
    requires java.net.http;
    requires spring.context;

    opens com.example.dostorresjava to javafx.fxml;
    exports com.example.dostorresjava;
}