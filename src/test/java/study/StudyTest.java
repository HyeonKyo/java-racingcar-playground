package study;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

public class StudyTest {

    @RepeatedTest(value = 10)
    void randomBound() {
        int bound = 10;
        Random random = new Random();

        int randomNumber = random.nextInt(bound);
        System.out.println(randomNumber);
        assertThat(randomNumber).isBetween(0, bound);
    }
}
