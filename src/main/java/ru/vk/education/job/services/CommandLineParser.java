package ru.vk.education.job.services;

import ru.vk.education.job.commands.Command;
import ru.vk.education.job.commands.ParsedCommand;

import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;

public class CommandLineParser implements ArgumentParser {
    private final static Scanner scanner = new Scanner(System.in);
    private final CommandParser commandParser;

    public CommandLineParser(CommandParser commandParser){
        this.commandParser = commandParser;
    }

    @Override
    public ParsedCommand parseArguments() {
        String scannedLine = scanner.nextLine();
        return commandParser.parseLine(scannedLine);
    }

}
