package com.example.demolistview.repositories;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class PersonFilesRepository {

    private final Path filePath = Paths.get("data", "persons.csv");

    // AQUÍ VA EL MÉTODO CORREGIDO
    private void ensureFile() throws IOException {
        // 1. Verifica si la carpeta "data" existe, si no, la crea
        if (filePath.getParent() != null && Files.notExists(filePath.getParent())) {
            Files.createDirectories(filePath.getParent());
        }
        // 2. Verifica si el archivo "persons.csv" existe, si no, lo crea
        if (Files.notExists(filePath)) {
            Files.createFile(filePath);
        }
    }

    public List<String> readAllLines() throws IOException {
        ensureFile(); // Se llama aquí para asegurar que el archivo existe antes de leer
        return Files.readAllLines(filePath);
    }

    public void appendNewLine(String line) throws IOException {
        ensureFile(); // Se llama aquí para asegurar que el archivo existe antes de escribir
        Files.writeString(filePath, line + System.lineSeparator(),
                StandardCharsets.UTF_8, StandardOpenOption.APPEND);
    }
}