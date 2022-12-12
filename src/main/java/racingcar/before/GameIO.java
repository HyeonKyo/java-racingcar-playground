package racingcar.before;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class GameIO {

    private static final String INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String ERROR_MESSAGE = "잘못된 입력입니다.";
    public static final String WIN_MESSAGE = "가 최종 우승했습니다.";
    public static final String TURN_MESSAGE = "시도할 횟수는 몇회인가요?";

    public String[] inputCarNames() {
        Scanner scanner = new Scanner(System.in);
        String[] names = null;
        while (names == null || isNotValid(names)) {
            System.out.println(INPUT_MESSAGE);
            String input = scanner.nextLine();
            names = input.split(",");
        }
        return names;
    }

    public int inputTurnNumber() {
        Scanner scanner = new Scanner(System.in);
        String input = null;
        while (input == null || isNotValid(input)) {
            System.out.println(TURN_MESSAGE);
            input = scanner.nextLine().trim();
        }
        return Integer.parseInt(input);
    }

    public void printWinner(List<String> winners) {
        StringBuilder winnersMessage = new StringBuilder();
        appendWinners(winners, winnersMessage);
        winnersMessage.append(WIN_MESSAGE);

        System.out.println(winnersMessage);
    }

    private void appendWinners(List<String> winners, StringBuilder winnersMessage) {
        for (String winner : winners) {
            winnersMessage.append(winner).append(", ");
        }
        deleteLastComma(winnersMessage);
    }

    private boolean isNotValid(String input) {
        try {
            Integer.parseInt(input);
            return false;
        } catch (NumberFormatException e) {
            System.out.println(ERROR_MESSAGE);
        }
        return true;
    }

    private boolean isNotValid(String[] names) {
        if (Arrays.stream(names).anyMatch(name -> name.length() > 5)) {
            System.out.println(ERROR_MESSAGE);
            return true;
        }
        return false;
    }

    private void deleteLastComma(StringBuilder winnersMessage) {
        int lastCommaIndex = winnersMessage.lastIndexOf(",");
        int messageLength = winnersMessage.length();
        winnersMessage.delete(lastCommaIndex, messageLength);
    }
}
