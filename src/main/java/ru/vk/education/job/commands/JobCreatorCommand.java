package ru.vk.education.job.commands;

import ru.vk.education.job.services.JobService;
import ru.vk.education.job.services.UserService;

import java.util.Map;

public class JobCreatorCommand implements CommandStrategy{
    private final JobService jobService;

    public JobCreatorCommand(JobService jobService){
        this.jobService = jobService;
    }

    @Override
    public void execute(Map<String, String> options) {
        jobService.addVacancy(options);
    }
}
