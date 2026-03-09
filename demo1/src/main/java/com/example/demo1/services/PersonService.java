package com.example.demo1.services;

import com.example.demo1.repositories.personFileRepository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PersonService {

    private personFileRepository repo = new personFileRepository();

    public List<String>LoaddataForList() throws IOException {
        List<String> lines = repo.readAllLines();
        List<String> result = new ArrayList<>();
        for (String line : lines) {
            if (line == null || line.isBlank()) continue;
            String [] parts = line.split(",", -1);
            String name= parts[0].trim();
            String correo=parts[1].trim();
            result.add(name+"-"+correo);
        }
        return result;

    }
    public void addPerson(String name, String email){
        repo.appendNewline(name+","email);

    }
    private void validateperson(String name, String email){
        if (name.isBlank() || name.length()<5){
            throw new IllegalArgumentException("El nombre no cumple con los estandares");
        }
    }
}
