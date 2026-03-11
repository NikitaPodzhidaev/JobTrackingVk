package ru.vk.education.job.commands;

import java.util.Map;

public record ParsedCommand(Commands commands, Map<String, String> options) {

}
