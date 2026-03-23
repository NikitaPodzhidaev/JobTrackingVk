package ru.vk.education.job.services;

import ru.vk.education.job.domains.User;
import ru.vk.education.job.domains.Vacancy;

import java.util.AbstractMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static ru.vk.education.job.commands.JobListCommand.JOB_LIST_OUT_PATTERN;

public class MatchExecutor {

    private MatchExecutor(){}

    public static void executeMatch(User user, List<Vacancy> vacancyList){

        List<Vacancy> suggestedVacancies = vacancyList.stream()
                .map(vacancy -> new AbstractMap.SimpleEntry<>(vacancy, calculateScore(user, vacancy)))
                .filter(entry -> entry.getValue() > 0)
                .sorted((e1,e2) -> Double.compare(e2.getValue(), e1.getValue()))
                .limit(2)
                .map(Map.Entry::getKey)
                .toList();

        suggestedVacancies.forEach(vacancy ->
                System.out.printf(JOB_LIST_OUT_PATTERN,
                        vacancy.getVacancyName(),
                        vacancy.getCompany())
        );


    }

    private static double calculateScore(User user, Vacancy vacancy) {
        Set<String> userSkills = user.getSkills().stream()
                .map(String::toLowerCase)
                .collect(Collectors.toSet());

        long matches = vacancy.getTags().stream()
                .map(String::toLowerCase)
                .filter(userSkills::contains)
                .count();

        double score = matches;

        if (user.getExperience() < vacancy.getExperience()) {
            score /= 2.0;
        }

        return score;
    }

}
