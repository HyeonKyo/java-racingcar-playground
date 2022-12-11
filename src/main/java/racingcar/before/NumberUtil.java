package racingcar.before;

import java.util.Random;

public class NumberUtil {
    private static final Random random = new Random();

    public static int makeNumber(int maxValue) {
        return random.nextInt(maxValue + 1);
    }
}
