package com.example.demeemer;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class HelloController {

    @FXML private TextField txtNombre;
    @FXML private TextField txtTelefono;
    @FXML private ComboBox<String> cbParentesco;
    @FXML private ListView<Contacto> listViewContactos;

    private ObservableList<Contacto> listaContactos = FXCollections.observableArrayList();

    private String[] arregloParentescos = {"Padre", "Madre", "Hermano", "Hermana", "Abuelo", "Abuela", "Tío", "Tía"};

    @FXML
    public void initialize() {
        cbParentesco.setItems(FXCollections.observableArrayList(arregloParentescos));

        listViewContactos.setItems(listaContactos);
    }

    @FXML
    public void agregarContacto() {
        String nombre = txtNombre.getText().trim();
        String telefono = txtTelefono.getText().trim();
        String parentesco = cbParentesco.getValue();

        if (nombre.isEmpty() || telefono.isEmpty() || parentesco == null) {
            mostrarAlerta("Error", "Todos los campos son obligatorios.");
            return;
        }
        if (telefono.length() != 10 || !telefono.matches("\\d+")) {
            mostrarAlerta("Error", "El teléfono debe tener exactamente 10 dígitos numéricos.");
            return;
        }
        if (existeContacto(nombre)) {
            mostrarAlerta("Error", "Ya existe un contacto con ese nombre.");
            return;
        }

        Contacto nuevo = new Contacto(nombre, telefono, parentesco);
        listaContactos.add(nuevo);
        limpiarCampos();
    }

    @FXML
    public void buscarContacto() {
        String nombreBuscado = txtNombre.getText().trim();
        if (nombreBuscado.isEmpty()) {
            mostrarAlerta("Error", "Escribe un nombre para buscar.");
            return;
        }

        for (Contacto c : listaContactos) {
            if (c.getNombre().equalsIgnoreCase(nombreBuscado)) {
                txtTelefono.setText(c.getTelefono());
                cbParentesco.setValue(c.getParentesco());
                return;
            }
        }
        mostrarAlerta("No encontrado", "No se encontró ningún contacto con ese nombre.");
    }

    @FXML
    public void actualizarContacto() {
        String nombre = txtNombre.getText().trim();
        String nuevoTelefono = txtTelefono.getText().trim();
        String nuevoParentesco = cbParentesco.getValue();

        if (nuevoTelefono.length() != 10 || !nuevoTelefono.matches("\\d+")) {
            mostrarAlerta("Error", "El teléfono debe tener 10 dígitos numéricos.");
            return;
        }

        for (Contacto c : listaContactos) {
            if (c.getNombre().equalsIgnoreCase(nombre)) {
                c.setTelefono(nuevoTelefono);
                c.setParentesco(nuevoParentesco);
                listViewContactos.refresh();
                mostrarAlerta("Éxito", "Contacto actualizado.");
                return;
            }
        }
        mostrarAlerta("Error", "Busque el contacto primero antes de actualizar.");
    }

    @FXML
    public void eliminarContacto() {
        String nombre = txtNombre.getText().trim();
        Contacto aEliminar = null;

        for (Contacto c : listaContactos) {
            if (c.getNombre().equalsIgnoreCase(nombre)) {
                aEliminar = c;
                break;
            }
        }

        if (aEliminar != null) {
            listaContactos.remove(aEliminar);
            limpiarCampos();
        } else {
            mostrarAlerta("Error", "Contacto no encontrado para eliminar.");
        }
    }

    @FXML
    public void limpiarCampos() {
        txtNombre.clear();
        txtTelefono.clear();
        cbParentesco.setValue(null);
    }

    private boolean existeContacto(String nombre) {
        for (Contacto c : listaContactos) {
            if (c.getNombre().equalsIgnoreCase(nombre)) return true;
        }
        return false;
    }

    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}