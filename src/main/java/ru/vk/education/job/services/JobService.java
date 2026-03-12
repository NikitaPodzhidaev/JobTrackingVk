package ru.vk.education.job.services;

import ru.vk.education.job.domains.User;
import ru.vk.education.job.domains.Vacancy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class JobService {

    private final List<Vacancy> vacancies = new ArrayList<>();

    public void addVacancy(Map<String, String> options){
        String name = options.get("name");
        String company = options.get("company");
        List<String> tags = Arrays.asList(options.get("tags").split(","));
        int exp = Integer.parseInt(options.get("exp"));
        vacancies.add(new Vacancy(name, company, tags, exp));
    }

    public List<Vacancy> getVacancies() {
        return vacancies;
    }
}
