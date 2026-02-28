package com.example.demologin; // <-- Verifica que este sea tu paquete

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloController {

    // Conectamos las variables con los fx:id del FXML
    @FXML
    private TextField txtCorreo;

    @FXML
    private PasswordField txtPassword;

    @FXML
    private Label lblError;

    @FXML
    protected void onHelloButtonClick(ActionEvent event) {
        // Obtenemos el texto ingresado
        String correo = txtCorreo.getText().trim();
        String password = txtPassword.getText();

        // Limpiamos errores previos
        lblError.setText("");

        // Regla 1: Correo no vacío y mínimo 4 caracteres
        if (correo.isEmpty() || correo.length() < 4) {
            lblError.setText("Error: El correo debe tener al menos 4 caracteres.");
            return;
        }

        // Regla 2: Correo válido (que incluya @ y .)
        if (!correo.contains("@") || !correo.contains(".")) {
            lblError.setText("Error: Formato de correo inválido.");
            return;
        }

        // Regla 3: Password mínimo 6 caracteres
        if (password.length() < 6) {
            lblError.setText("Error: La contraseña debe tener al menos 6 caracteres.");
            return;
        }

        // --- SI PASA TODAS LAS VALIDACIONES ---
        String nombreUsuario = correo.substring(0, correo.indexOf("@"));
        lblError.setStyle("-fx-text-fill: green;");
        lblError.setText("¡Éxito! Cargando dashboard...");

        // --- CÓDIGO PARA CARGAR EL DASHBOARD ---
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("dashboard.fxml"));
            Parent root = loader.load();

            DashboardController dashboardController = loader.getController();
            dashboardController.setUsuario(nombreUsuario);

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
            lblError.setText("Error al cargar la pantalla del Dashboard.");
        }
    }
}