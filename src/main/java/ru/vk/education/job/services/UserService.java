package ru.vk.education.job.services;


import ru.vk.education.job.domains.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class UserService {

    private final List<User> users = new ArrayList<>();

    public void addUser(Map<String, String> options){
        String name = options.get("name");
        List<String> skills = Arrays.asList(options.get("skills").split(","));
        int exp = Integer.parseInt(options.get("exp"));
        users.add(new User(name, skills, exp));
    }

    public List<User> getUsers() {
        return users;
    }
}
