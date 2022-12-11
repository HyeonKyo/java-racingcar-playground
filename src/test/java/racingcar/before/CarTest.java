package racingcar.before;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

/**
 * [ ] 생성 TEST
 * [ ] move() Test
     * [ ] 랜덤 메소드 -> 랜덤 분리하기
     * [ ] 해당 값이 4이상이면 dist++ && true 리턴
            아니면 false 리턴
 * [ ] print Test
 */
public class CarTest {

    Car car;
    String name;

    @BeforeEach
    void setUp() {
        name = "abc";
        car = new Car(name);
    }

    @Test
    void 생성_test() {
        assertThat(car).isNotNull();
        assertThat(car.getName()).isEqualTo(name);
    }

    @Test
    void move_test() {
        int notMoveDistance = Car.MIN_MOVE_VALUE - 1;
        int moveDistance = Car.MIN_MOVE_VALUE;
        assertThat(car.move(notMoveDistance)).isFalse();
        assertThat(car.getDistance()).isZero();
        assertThat(car.move(moveDistance)).isTrue();
        assertThat(car.getDistance()).isOne();
    }

    @Test
    void move_유효성검사() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> car.move(10));
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> car.move(-1));
    }

    @Test
    void print_테스트() {
        String message = String.format("%s : --", name);
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        car.move(Car.MIN_MOVE_VALUE);
        car.move(Car.MIN_MOVE_VALUE);
        car.print();

        assertThat(out.toString()).contains(message);
    }
}
