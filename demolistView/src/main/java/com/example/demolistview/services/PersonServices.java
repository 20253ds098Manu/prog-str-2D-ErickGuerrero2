package com.example.demolistview.services;

import com.example.demolistview.repositores.PersonFileRepository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PersonServices {
    private PersonFileRepository repo = new PersonFileRepository();

    public List<String> loadDataForList() throws IOException {
        List<String> lines = repo.readAllLines();
        List<String> result = new ArrayList<>();
        for (String line : lines){
            if (line==null || line.isBlank()) continue;

            String[] parts = line.split(",", -1);
            String name = parts[0].trim();
            String correo = parts[1].trim();
            String edad = parts[2].trim();
            result.add(name+" - "+correo+" - "+edad);
        }
        return result;
    }

    public void addPerson(String nombre, String email, String edad) throws IOException {
        validatePerson(nombre,email,edad);
        String nameNoComan = nombre.replace(",", "");
        String emailNoComan = email.replace(",", "");
        String edadNoComan = edad.replace(",", "");

        repo.appendNewLine(nameNoComan+","+emailNoComan+","+edadNoComan);
    }
    private void validatePerson(String nombre, String email, String edad){
        if (nombre.isBlank() || nombre.isEmpty() || nombre.length()<3 ) {
            throw new IllegalArgumentException("El nombre no cumple con los estandares");
        }
        String em = (email==null) ? "" : email.trim();
        if (em.isEmpty() || !em.contains("@") || !em.contains(".")){
            throw new IllegalArgumentException("El email no es valido");
        }
        try {
            int numEdad = Integer.parseInt(edad.trim());
            if (!(numEdad >=18)){
                throw new IllegalArgumentException("Solo se aceptan mayores de 18");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("La edad debe ser numerica");
        }
    }
}
