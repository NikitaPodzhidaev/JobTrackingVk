package ru.vk.education.job.services;

import ru.vk.education.job.domains.User;
import ru.vk.education.job.domains.Vacancy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class JobService {

    private final List<Vacancy> vacancies = new ArrayList<>();

    public void addVacancy(Map<String, String> options) {
        String vacancyName = options.get("name");
        String company = options.get("company");
        List<String> tags = Arrays.asList(options.get("tags").split(","));
        int exp = Integer.parseInt(options.get("exp"));

        for (Vacancy vacancy : vacancies) {
            if (vacancy.getVacancyName().equals(vacancyName)) {
                return;
            }
        }

        vacancies.add(new Vacancy(vacancyName, company, tags, exp));
    }

    public List<Vacancy> getVacancies() {
        return vacancies;
    }
}
