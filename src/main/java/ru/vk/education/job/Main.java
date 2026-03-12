package ru.vk.education.job;

import ru.vk.education.job.commands.CommandExecutor;
import ru.vk.education.job.commands.ParsedCommand;
import ru.vk.education.job.services.ArgumentParser;
import ru.vk.education.job.services.CommandLineParser;
import ru.vk.education.job.services.JobService;
import ru.vk.education.job.services.UserService;

public class Main {
    public static void main(String[] args) {
        UserService userService = new UserService();
        JobService jobService = new JobService();
        CommandExecutor commandExecutor = new CommandExecutor(userService, jobService);
        ArgumentParser commandLineParser = new CommandLineParser();

        while(true){
            ParsedCommand parsedCommand = commandLineParser.parseArguments();
            commandExecutor.executeCommand(parsedCommand);
        }

    }
}