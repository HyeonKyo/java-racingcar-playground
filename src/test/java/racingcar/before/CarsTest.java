package racingcar.before;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {
    String name1 = "car1";
    String name2 = "car2";
    String name3 = "car3";

    Car car1;
    Car car2;
    Car car3;
    Cars cars;

    @BeforeEach
    void setUp() {
        car1 = new Car(name1);
        car2 = new Car(name2);
        car3 = new Car(name3);
        cars = new Cars(Arrays.asList(car1, car2, car3));
    }

    @Test
    void 생성_Test() {
        assertThat(cars).isNotNull();
        assertThat(cars.getCars()).isNotNull();
        assertThat(cars.getCars().size()).isEqualTo(3);
    }

    @Test
    void turn_수행_출력확인() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        cars.executeTurn();
        assertThat(out.toString()).contains(String.format("%s : ", car1.getName()));
        assertThat(out.toString()).contains(String.format("%s : ", car2.getName()));
        assertThat(out.toString()).contains(String.format("%s : ", car3.getName()));
    }

    @Test
    void 우승자_이름_리턴_test() {
        for (int i = 0; i < 5; i++) {
            cars.executeTurn();
        }
        List<String> actualWinners = findActualWinners();
        List<String> winners = cars.getWinners();

        assertThat(winners.size()).isGreaterThan(0);
        assertThat(winners.size()).isEqualTo(actualWinners.size());
        for (String winner : winners) {
            assertThat(actualWinners.contains(winner)).isTrue();
        }
    }

    private List<String> findActualWinners() {
        List<String> winnerList = new ArrayList<>();
        int max = 0;

        List<Car> carList = cars.getCars();
        for (Car car : carList) {
            if (car.getDistance() >= max) {
                if (car.getDistance() > max) {
                    winnerList.clear();
                    max = car.getDistance();
                }
                winnerList.add(car.getName());
            }
        }
        return winnerList;
    }
}
