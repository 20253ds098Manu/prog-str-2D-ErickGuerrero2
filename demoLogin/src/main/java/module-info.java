module com.example.demologin {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens com.example.demologin to javafx.fxml;
    exports com.example.demologin;
}