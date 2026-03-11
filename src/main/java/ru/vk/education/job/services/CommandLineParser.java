package ru.vk.education.job.services;

import ru.vk.education.job.commands.Commands;
import ru.vk.education.job.commands.ParsedCommand;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CommandLineParser implements ArgumentParser {

    @Override
    public ParsedCommand parseArguments() {
        return parseCommandLine();
    }

    private ParsedCommand parseCommandLine(){
        Scanner scanner = new Scanner(System.in);
        String[] splitScannerLine = scanner.nextLine().trim().split("\\s+");
        checkCommand(splitScannerLine);
        Commands command = Commands.valueOf(splitScannerLine[0].toUpperCase());
        Map<String, String> options = parseOptions(splitScannerLine);
        return new ParsedCommand(command, options);
    }

    private void checkCommand(String[] splitLine){
        try {
            Commands.valueOf(splitLine[0].toUpperCase());
        } catch (IllegalArgumentException illegalArgumentException){
            throw new IllegalArgumentException("That command isn't supported");
        }
    }

    private Map<String, String> parseOptions(String[] split) {
        Map<String, String> options = new HashMap<>();
        if (split.length > 1 && !split[1].startsWith("--")) {
            options.put("name", split[1]);
        }

        for (int i = 2; i < split.length; i++) {
            String arg = split[i];
            if (arg.startsWith("--")) {
                int idx = arg.indexOf('=');
                if (idx == -1) throw new IllegalArgumentException("Invalid argument: " + arg);
                options.put(arg.substring(2, idx), arg.substring(idx + 1));
            }
        }

        return options;
    }


}
