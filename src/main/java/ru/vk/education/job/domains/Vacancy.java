package ru.vk.education.job.domains;

import java.util.ArrayList;

public class Vacancy {

    private String vacancyName;
    private String company;
    private ArrayList<String> tags;
    private int experience;

    public Vacancy(String vacancyName, String company, ArrayList<String> tags, int experience){
        this.vacancyName = vacancyName;
        this.company = company;
        this.tags = tags;
        this.experience = experience;
    }


}
