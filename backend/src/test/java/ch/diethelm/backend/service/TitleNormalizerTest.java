package ch.diethelm.backend.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class TitleNormalizerTest {
    @Test
    void normalize_trimsSurroundingSpaces() {
        Assertions.assertEquals("Zelda", TitleNormalizer.normalize(" Zelda "));
    }

    @Test
    void normalize_collapsesMultipleSpaces() {
        Assertions.assertEquals("The Legend of Zelda", TitleNormalizer.normalize("The  Legend  of  Zelda"));
    }

    @Test
    void normalize_capitalisesFirstLetter() {
        Assertions.assertEquals("Zelda", TitleNormalizer.normalize("zelda"));
    }
}
