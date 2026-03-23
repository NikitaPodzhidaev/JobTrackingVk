package ru.vk.education.job.commands;

import ru.vk.education.job.domains.User;
import ru.vk.education.job.services.CommandIterator;
import ru.vk.education.job.services.FileService;
import ru.vk.education.job.services.JobService;
import ru.vk.education.job.services.UserService;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CommandExecutor {

    private final Map<Command, CommandStrategy> strategyMap = new HashMap<>();

    public CommandExecutor(UserService userService, JobService jobService, FileService fileService) {

        strategyMap.put(Command.JOB, new JobCreatorCommand(jobService));
        strategyMap.put(Command.USER, new UserCreatorCommand(userService));
        strategyMap.put(Command.SUGGEST, new SuggestCommand(jobService, userService));
        strategyMap.put(Command.JOB_LIST, new JobListCommand(jobService));
        strategyMap.put(Command.USER_LIST, new UserListCommand(userService));
        strategyMap.put(Command.HISTORY, new HistoryCommand(fileService));
        strategyMap.put(Command.EXIT, new ExitCommand());

    }

    public void executeCommand(ParsedCommand parsedCommand, FileService fileService) throws IOException {
        CommandStrategy strategy = strategyMap.get(parsedCommand.command());
        strategy.execute(parsedCommand.options());
        fileService.logCommand(parsedCommand.unparsedCommand());
    }

    public void executeFileCommands(ParsedCommand parsedCommand, FileService fileService) throws IOException {
        if (parsedCommand.command() == Command.USER
                || parsedCommand.command() == Command.JOB) {

            CommandStrategy strategy = strategyMap.get(parsedCommand.command());
            strategy.execute(parsedCommand.options());

        }
    }
}