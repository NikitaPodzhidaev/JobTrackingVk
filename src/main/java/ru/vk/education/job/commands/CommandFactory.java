package ru.vk.education.job.commands;

public class CommandFactory {
    Command create(ParsedCommand parsedCommand){
        switch(parsedCommand.commands()){
            case USER -> return new UserCreatorCommand(parsedCommand.options());
        }
    }
}
