package ru.vk.education.job.commands;

import ru.vk.education.job.domains.User;
import ru.vk.education.job.services.JobService;
import ru.vk.education.job.services.MatchExecutor;
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
        String username = options.get("name");
        User user = userService.getUsers().stream()
                .filter(u -> u.getName().equals(username))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("User not found: " + username));
        MatchExecutor.executeMatch(user, jobService.getVacancies());

    }
}
