package ru.vk.education.job.domains;

import java.util.ArrayList;
import java.util.List;

public class Vacancy {

    private String vacancyName;
    private String company;
    private List<String> tags;
    private int experience;

    public Vacancy(String vacancyName, String company, List<String> tags, int experience){
        this.vacancyName = vacancyName;
        this.company = company;
        this.tags = tags;
        this.experience = experience;
    }

    public int getExperience() {
        return experience;
    }

    public List<String> getTags() {
        return tags;
    }

    public String getCompany() {
        return company;
    }

    public String getVacancyName() {
        return vacancyName;
    }
}
