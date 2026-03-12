package ru.vk.education.job.commands;

import ru.vk.education.job.domains.User;
import ru.vk.education.job.domains.Vacancy;
import ru.vk.education.job.services.JobService;

import java.util.List;
import java.util.Map;

public class JobListCommand implements CommandStrategy {

    private static final String JOB_LIST_OUT_PATTERN = "%s at %s\n";


    private final JobService jobService;
    public JobListCommand(JobService jobService){
        this.jobService = jobService;
    }

    @Override
    public void execute(Map<String, String> options) {
        List<Vacancy> vacancies = jobService.getVacancies();
        vacancies.forEach(vacancy -> System.out.printf(JOB_LIST_OUT_PATTERN, vacancy.getVacancyName(), vacancy.getCompany()));
    }
}
