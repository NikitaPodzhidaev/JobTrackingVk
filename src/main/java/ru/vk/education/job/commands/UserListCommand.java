package ru.vk.education.job.commands;

import ru.vk.education.job.domains.User;
import ru.vk.education.job.services.UserService;

import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class UserListCommand implements CommandStrategy {
    private final static String USER_LIST_OUTPUT_PATTERN = "%s %s %d\n";
    private final UserService userService;

    public UserListCommand(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void execute(Map<String, String> options) {
        List<User> users = userService.getUsers();

        users.forEach(user -> {
            String skills = String.join(",", new TreeSet<>(user.getSkills()));

            System.out.printf(
                    USER_LIST_OUTPUT_PATTERN,
                    user.getName(),
                    skills,
                    user.getExperience()
            );
        });
    }
}
