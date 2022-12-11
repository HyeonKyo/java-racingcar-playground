package racingcar.before;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class NumberUtilTest {

    @RepeatedTest(value = 10)
    void random_0_9테스트() {
        int randomNumber = NumberUtil.makeNumber(Car.MAX_VALUE);
        assertThat(randomNumber).isBetween(0, Car.MAX_VALUE);
    }

}
