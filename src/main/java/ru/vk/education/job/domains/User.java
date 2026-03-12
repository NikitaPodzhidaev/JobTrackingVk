package ru.vk.education.job.domains;

import java.util.List;

public class User {

    private final String name;
    private final List<String> skills;
    private final int experience;

    public User(String name, List<String> skills, int experience){
        this.name = name;
        this.skills = skills;
        this.experience = experience;
    }

    public String getName() {
        return name;
    }

    public List<String> getSkills() {
        return skills;
    }

    public int getExperience() {
        return experience;
    }
}
