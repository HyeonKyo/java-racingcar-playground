package racingcar.before;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private List<Car> cars;

    public Cars(String[] names) {
        this.cars = mapCars(names);
    }

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void executeTurn() {
        cars.forEach(car -> {
            car.move(NumberUtil.makeNumber(Car.MAX_VALUE));
            car.print();
        });
        System.out.println();
    }

    public List<String> getWinners() {
        int maxDistance = getMaxDistance();
        return cars.stream()
                .filter(car -> car.getDistance() == maxDistance)
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    private List<Car> mapCars(String[] names) {
        return Arrays.stream(names)
                .map(Car::new)
                .collect(Collectors.toList());
    }

    private int getMaxDistance() {
        return cars.stream()
                .max(Comparator.comparingInt(Car::getDistance))
                .orElseThrow(RuntimeException::new)
                .getDistance();
    }
}
