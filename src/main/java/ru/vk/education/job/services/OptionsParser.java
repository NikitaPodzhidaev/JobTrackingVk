package ru.vk.education.job.services;

import java.util.HashMap;
import java.util.Map;

public class OptionsParser {

    private OptionsParser() {};


    public static Map<String, String> parseOptions(String[] split) {
        Map<String, String> options = new HashMap<>();
        if (split.length > 1 && !split[1].startsWith("--")) {
            options.put("name", split[1]);
        }
        for (int i = 2; i < split.length; i++) {
            String arg = split[i];
            if (arg.startsWith("--")) {
                int idx = arg.indexOf('=');
                if (idx == -1) throw new IllegalArgumentException("Invalid argument: " + arg);
                options.put(arg.substring(2, idx), arg.substring(idx + 1));
            }
        }
        return options;
    }
}
