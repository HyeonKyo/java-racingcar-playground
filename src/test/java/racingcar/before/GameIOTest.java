package racingcar.before;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class GameIOTest {

    public static final String ERROR_MESSAGE = "잘못된 입력입니다.";
    String name1 = "car1";
    String name2 = "car2";

    GameIO gameIO;

    @BeforeEach
    void setUp() {
        gameIO = new GameIO();
    }

    @Test
    void 자동차_이름_입력_test() {
        System.setIn(new ByteArrayInputStream(String.format("%s,%s", name1, name2).getBytes()));
        String[] names = gameIO.inputCarNames();

        assertThat(names.length).isEqualTo(2);
        assertThat(names[0]).isEqualTo(name1);
        assertThat(names[1]).isEqualTo(name2);
    }

    @Test
    void 이름_5자_검사_test() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        String wrongName = "abcdef";
        System.setIn(new ByteArrayInputStream(String.format("%s,%s\n%s,%s\n", name1, wrongName, name1, name2).getBytes()));

        gameIO.inputCarNames();
        assertThat(out.toString()).contains(ERROR_MESSAGE);
    }

    @Test
    void 턴_횟수_입력_test() {
        int turn = 5;
        System.setIn(new ByteArrayInputStream(String.format("%d\n", turn).getBytes()));
        int inputTurn = gameIO.inputTurnNumber();

        assertThat(inputTurn).isEqualTo(turn);
    }

    @Test
    void 턴_횟수_입력_예외처리() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        System.setIn(new ByteArrayInputStream("a\n10\n".getBytes()));
        gameIO.inputTurnNumber();

        assertThat(out.toString()).contains(ERROR_MESSAGE);
    }

    @Test
    void 우승자_출력() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        List<String> winners = Arrays.asList("우승자1", "우승자2");
        gameIO.printWinner(winners);

        assertThat(out.toString()).contains("우승자1, 우승자2가 최종 우승했습니다.");
    }
}
