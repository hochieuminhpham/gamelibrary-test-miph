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
}
