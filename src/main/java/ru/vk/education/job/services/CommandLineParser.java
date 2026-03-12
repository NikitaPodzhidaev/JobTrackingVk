package ru.vk.education.job.services;

import ru.vk.education.job.commands.Command;
import ru.vk.education.job.commands.ParsedCommand;

import java.util.Map;
import java.util.Scanner;

public class CommandLineParser implements ArgumentParser {
    private final static Scanner scanner = new Scanner(System.in);

    @Override
    public ParsedCommand parseArguments() {
        return parseCommandLine();
    }

    private ParsedCommand parseCommandLine(){
        String[] splitScannerLine = scanner.nextLine().trim().split("\\s+");
        checkCommand(splitScannerLine);
        Command command = Command.from(splitScannerLine[0]);
        Map<String, String> options = OptionsParser.parseOptions(splitScannerLine);
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
