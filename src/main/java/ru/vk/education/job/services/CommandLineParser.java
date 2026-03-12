package ru.vk.education.job.services;

import ru.vk.education.job.commands.Command;
import ru.vk.education.job.commands.ParsedCommand;

import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;

public class CommandLineParser implements ArgumentParser {
    private final static Scanner scanner = new Scanner(System.in);

    @Override
    public ParsedCommand parseArguments() {
        return parseCommandLine();
    }

    private ParsedCommand parseCommandLine() {
        String line = scanner.nextLine().trim();

        if (line.isEmpty()) {
            throw new IllegalArgumentException("Команда не введена");
        }

        String[] splitScannerLine = line.split("\\s+");

        Command command;
        try {
            command = Command.from(splitScannerLine[0]);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Команда '" + splitScannerLine[0] + "' не поддерживается");
        }

        Map<String, String> options;
        try {
            options = OptionsParser.parseOptions(splitScannerLine);
        } catch (Exception e) {
            throw new IllegalArgumentException("Ошибка парсинга опций: " + e.getMessage(), e);
        }

        return new ParsedCommand(command, options);
    }

    // helper-method
    private void checkCommand(String[] splitLine){
        try {
            Command.from(splitLine[0]);
        } catch (IllegalArgumentException illegalArgumentException){
            throw new IllegalArgumentException("That command isn't supported");
        }
    }



}
