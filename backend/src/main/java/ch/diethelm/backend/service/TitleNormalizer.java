package ch.diethelm.backend.service;

public class TitleNormalizer {

    public static String normalize(String title) {
        String title2 = title.trim().replaceAll("\\s+", " ");
        String capLetter = title.substring(0,1).toUpperCase();

    return capLetter + title2.substring(1);
    }
}
