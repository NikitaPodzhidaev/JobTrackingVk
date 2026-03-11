package ru.vk.education.job;

import ru.vk.education.job.commands.CommandFactory;
import ru.vk.education.job.commands.ParsedCommand;
import ru.vk.education.job.services.ArgumentParser;
import ru.vk.education.job.services.CommandLineParser;

public class Main {
    public static void main(String[] args) {
        ArgumentParser commandLineParser = new CommandLineParser();
        ParsedCommand parsedCommand = commandLineParser.parseArguments();
        CommandFactory commandFactory = new CommandFactory();

    }
}