package ru.vk.education.job.services;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class FileService {

    private final Path initialPath;

    public FileService(String stringPath) {
        this.initialPath = checkEvaluatePath(stringPath);
    }

    private Path checkEvaluatePath(String initialStringPath) {
        try {
            return Path.of(initialStringPath);
        } catch (InvalidPathException e) {
            throw new IllegalArgumentException("Некорректный путь к файлу");
        }
    }

    public void logCommand(String logCommand) throws IOException {
        logCommand = logCommand + "\n";
        Files.writeString(
                initialPath,
                logCommand,
                StandardOpenOption.CREATE,
                StandardOpenOption.APPEND
        );
    }

    public List<String> getReadCommands() {
        try {
            if (Files.notExists(initialPath)) {
                return new ArrayList<>();
            }
            return Files.readAllLines(initialPath);
        } catch (IOException e) {
            throw new RuntimeException("Ошибка чтения файла", e);
        }
    }
}