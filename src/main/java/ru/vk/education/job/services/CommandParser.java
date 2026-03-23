package ru.vk.education.job.services;

import ru.vk.education.job.commands.Command;
import ru.vk.education.job.commands.ParsedCommand;

import java.util.Map;

public class CommandParser {


    public ParsedCommand parseLine(String line) {

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

        return new ParsedCommand(command, options, line);
    }

}
