package ru.vk.education.job.commands;

import java.util.Map;

public class ExitCommand implements CommandStrategy {
    @Override
    public void execute(Map<String, String> options) {
        System.exit(0);
    }
}
