package stringaddcalculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    public static int splitAndSum(String text) {
        if (isEmpty(text)) {
            return 0;
        }
        String[] numbers = splitByDelimiter(text);
        return sumNumbers(numbers);
    }

    private static boolean isEmpty(String text) {
        return text == null || text.isEmpty();
    }

    private static Integer sumNumbers(String[] tokens) {
        return Arrays.stream(tokens)
                .map(StringAddCalculator::mapInteger)
                .reduce(0, Integer::sum);
    }

    private static int mapInteger(String token) {
        int number = Integer.parseInt(token);
        checkPositiveValue(number);
        return number;
    }

    private static void checkPositiveValue(int number) {
        if (number < 0) {
            throw new RuntimeException();
        }
    }

    private static String[] splitByDelimiter(String text) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
        if (m.find()) {
            String customDelimiter = m.group(1);
            return m.group(2).split(customDelimiter);
        }
        return text.split(",|:");
    }
}
