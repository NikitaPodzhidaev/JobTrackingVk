package ru.vk.education.job.commands;

import ru.vk.education.job.services.JobService;

import java.util.Map;

public class JobListCommand implements CommandStrategy {

    private final JobService jobService;
    public JobListCommand(JobService jobService){
        this.jobService = jobService;
    }

    @Override
    public void execute(Map<String, String> options) {
        System.out.println("выбрали команду джоблист");
    }
}
