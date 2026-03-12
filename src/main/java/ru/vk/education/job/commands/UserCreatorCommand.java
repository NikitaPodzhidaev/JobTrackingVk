package ru.vk.education.job.commands;

import ru.vk.education.job.services.UserService;

import java.util.Map;

public class UserCreatorCommand implements CommandStrategy {

    private final UserService userService;

    public UserCreatorCommand(UserService userService){
        this.userService = userService;
    }

    @Override
    public void execute(Map<String, String> options) {
        userService.addUser(options);
    }
}
