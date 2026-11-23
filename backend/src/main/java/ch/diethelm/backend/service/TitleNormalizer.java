package ch.diethelm.backend.service;

import io.micrometer.common.util.StringUtils;

public class TitleNormalizer {

    public static String normalize(String title) {

        if (title == null || StringUtils.isBlank(title)) {
            throw new IllegalArgumentException();
        }

        String title2 = title.trim().replaceAll("\\s+", " ");
        String capLetter = title2.substring(0,1).toUpperCase();

    return capLetter + title2.substring(1);
    }
}
