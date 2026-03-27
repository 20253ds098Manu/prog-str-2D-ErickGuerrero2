1. En TurnoLecturaService.java
Busca los métodos que dicen // TODO y reemplázalos con esto:
// Lógica para AGREGAR un nuevo registro
public String agregar(String nombreAlumno, String libro, String turno) {
    // 1, 2 y 3. Validar que nada venga vacío o nulo
    if (nombreAlumno == null || nombreAlumno.trim().isEmpty()) return "El nombre no puede estar vacío";
    if (libro == null || libro.trim().isEmpty()) return "El libro no puede estar vacío";
    if (turno == null) return "Debe seleccionar un turno";

    // 4. Validar que el nombre no esté repetido (usando el repository)
    if (repository.buscarPorNombreAlumno(nombreAlumno.trim()) != null) {
        return "Error: El alumno ya tiene un turno asignado";
    }

    // 5 y 6. Crear el objeto con los datos limpios (.trim) y guardarlo
    TurnoLectura nuevo = new TurnoLectura(nombreAlumno.trim(), libro.trim(), turno);
    repository.guardar(nuevo);

    return null; // 7. Retornar null indica que no hubo errores
}

// Lógica para ACTUALIZAR un registro existente
public String actualizar(String nombreOriginal, String nombreNuevo, String libroNuevo, String turnoNuevo) {
    // 1. Validar que sepamos a quién estamos editando
    if (nombreOriginal == null || nombreOriginal.isEmpty()) return "Error de referencia original";

    // 2 y 3. Buscar el objeto original en la lista
    TurnoLectura registro = repository.buscarPorNombreAlumno(nombreOriginal);
    if (registro == null) return "El registro original no existe";

    // 4. Validar que los nuevos datos no estén vacíos
    if (nombreNuevo.isEmpty() || libroNuevo.isEmpty() || turnoNuevo == null) return "Campos vacíos";

    // 5. Si cambió el nombre, revisar que el nuevo nombre no lo tenga ya alguien más
    if (!nombreOriginal.equalsIgnoreCase(nombreNuevo)) {
        if (repository.buscarPorNombreAlumno(nombreNuevo) != null) {
            return "El nuevo nombre ya está en uso por otro alumno";
        }
    }

    // 6. Usar los setters para modificar el objeto directamente en la lista
    registro.setNombreAlumno(nombreNuevo.trim());
    registro.setLibro(libroNuevo.trim());
    registro.setTurno(turnoNuevo);

    return null; // 7. Éxito
}

// Lógica para ELIMINAR
public String eliminar(String nombreAlumno) {
    // 1. Validar que el campo nombre no esté vacío
    if (nombreAlumno == null || nombreAlumno.trim().isEmpty()) return "Nombre inválido";

    // 2, 3 y 4. Intentar borrar y avisar si no se encontró
    boolean eliminado = repository.eliminarPorNombreAlumno(nombreAlumno.trim());
    if (!eliminado) return "No se encontró el registro para eliminar";

    return null; // Éxito
}
boolean eliminado = repository.eliminarPorNombreAlumno(nombreAlumno.trim());
        if (!eliminado) return "No se encontró el registro para eliminar";

        return null; // Éxito
        }


        ---------------------------------




        2. En MainController.java
Pega estas funciones dentro de la clase para conectar la interfaz con el Service:
@FXML
public void agregar() {
    // Ejecuta el método del service y guarda el mensaje resultante
    String res = service.agregar(txtNombreAlumno.getText(), txtLibro.getText(), cbTurno.getValue());

    if (res == null) { // Si es null, funcionó
        actualizarLista(); // Refresca el ListView
        limpiar();         // Borra los TextFields
    } else {
        mostrarMensaje("Error", res, Alert.AlertType.ERROR); // Muestra el error del service
    }
}

@FXML
public void actualizar() {
    // Validación de seguridad: debe haber un nombreOriginal guardado previamente (por Buscar o clic)
    if (nombreOriginal == null) {
        mostrarMensaje("Error", "Primero busca o selecciona un registro", Alert.AlertType.WARNING);
        return;
    }

    String res = service.actualizar(nombreOriginal, txtNombreAlumno.getText(), txtLibro.getText(), cbTurno.getValue());

    if (res == null) {
        actualizarLista();
        limpiar();
    } else {
        mostrarMensaje("Error", res, Alert.AlertType.ERROR);
    }
}

@FXML
public void eliminar() {
    // Mandamos el nombre que esté en el cuadro de texto para borrar
    String res = service.eliminar(txtNombreAlumno.getText());

    if (res == null) {
        actualizarLista();
        limpiar();
    } else {
        mostrarMensaje("Error", res, Alert.AlertType.ERROR);
    }
}
