package ru.vk.education.job.commands;

import java.util.Map;

public record ParsedCommand(Command command, Map<String, String> options) {

}
