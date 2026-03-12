package ru.vk.education.job.commands;

import ru.vk.education.job.services.JobService;
import ru.vk.education.job.services.UserService;

import java.util.Map;

public class SuggestCommand implements CommandStrategy {

    private final JobService jobService;
    private final UserService userService;

    public SuggestCommand(JobService jobService, UserService userService) {
        this.jobService = jobService;
        this.userService = userService;
    }


    @Override
    public void execute(Map<String, String> options) {
        System.out.println("выбрали команду суджест");
    }
}
