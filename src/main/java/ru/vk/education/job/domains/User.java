package ru.vk.education.job.domains;

import java.util.ArrayList;

public class User {

    private String name;
    private ArrayList<String> skills;
    private int experience;

    public User(String name, ArrayList<String> skills, int experience){
        this.name = name;
        this.skills = skills;
        this.experience = experience;
    }




}
