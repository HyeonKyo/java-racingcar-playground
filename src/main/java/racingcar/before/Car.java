package racingcar.before;

public class Car {
    public static final int MIN_MOVE_VALUE = 4;
    public static final int MIN_VALUE = 0;
    public static final int MAX_VALUE = 9;

    private String name;
    private int distance;

    public Car(String name) {
        this.name = name;
    }

    public void move(int value) {
        checkRangeOfValue(value);
        if (value >= MIN_MOVE_VALUE) {
            distance++;
        }
    }

    private void checkRangeOfValue(int value) {
        if (value < MIN_VALUE || value > MAX_VALUE) {
            throw new IllegalArgumentException();
        }
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }

    public void print() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(name)
                .append(" : ");
        for (int i = 0; i < distance; i++) {
            stringBuilder.append("-");
        }
        System.out.println(stringBuilder);
    }
}
