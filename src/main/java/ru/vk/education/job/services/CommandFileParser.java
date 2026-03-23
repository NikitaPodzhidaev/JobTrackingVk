package ru.vk.education.job.services;

import ru.vk.education.job.commands.ParsedCommand;

import java.util.List;

public class CommandFileParser implements ArgumentParser{

    private final CommandParser commandParser;
    private final List<String> commandsFromFile;
    private int currentIndex = 0;

    public CommandFileParser(List<String> commandsFromFile, CommandParser commandParser) {
        this.commandsFromFile = commandsFromFile;
        this.commandParser = commandParser;
    }

    @Override
    public ParsedCommand parseArguments() {
        if(currentIndex >= commandsFromFile.size()) throw new IllegalStateException("Команды в файле закончились");
        String stringCommand = commandsFromFile.get(currentIndex++);
        return commandParser.parseLine(stringCommand);
    }


    public boolean hasNext() {
        return currentIndex < commandsFromFile.size();
    }
}
