package ru.vk.education.job.services;

import ru.vk.education.job.commands.ParsedCommand;

public interface ArgumentParser {
    ParsedCommand parseArguments();

}
