package ru.vk.education.job.commands;

import java.util.Map;

@FunctionalInterface
public interface CommandStrategy {
    void execute(Map<String, String> options);
}
