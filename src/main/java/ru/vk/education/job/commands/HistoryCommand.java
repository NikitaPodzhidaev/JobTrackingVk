package ru.vk.education.job.commands;

import ru.vk.education.job.services.FileService;

import java.util.Map;

public class HistoryCommand implements CommandStrategy {

    private final FileService fileService;

    public HistoryCommand(FileService fileService){
        this.fileService = fileService;
    }

    @Override
    public void execute(Map<String, String> options) {
        for(String str : fileService.getReadCommands()){
            System.out.println(str);
        }
    }
}
