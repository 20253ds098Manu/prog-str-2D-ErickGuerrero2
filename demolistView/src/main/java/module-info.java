module com.example.demolistview {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens com.example.demolistview to javafx.fxml;
    exports com.example.demolistview;
}