package ru.vk.education.job.commands;

public enum Command {
    USER,
    USER_LIST,
    JOB,
    JOB_LIST,
    SUGGEST,
    EXIT;

    public static Command from(String input) {
        return Command.valueOf(input.replace("-", "_").toUpperCase());
    }



}
