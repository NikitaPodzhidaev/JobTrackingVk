package ru.vk.education.job;

import ru.vk.education.job.commands.CommandExecutor;
import ru.vk.education.job.commands.ParsedCommand;
import ru.vk.education.job.services.*;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        UserService userService = new UserService();
        JobService jobService = new JobService();
        FileService fileService = new FileService("log.txt");

        CommandExecutor commandExecutor = new CommandExecutor(userService, jobService, fileService);
        CommandParser commandParser = new CommandParser();
        ArgumentParser commandLineParser = new CommandLineParser(commandParser);
        CommandFileParser commandFileParser = new CommandFileParser(fileService.getReadCommands(), commandParser);

        while(commandFileParser.hasNext()){
            try {
                ParsedCommand parsedCommand = commandFileParser.parseArguments();
                commandExecutor.executeFileCommands(parsedCommand, fileService);
            } catch (Exception e){
                e.printStackTrace();
            }
        }

        while(true){
            try {
                ParsedCommand parsedCommand = commandLineParser.parseArguments();
                commandExecutor.executeCommand(parsedCommand, fileService);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }



    }
}