package racingcar.before;

import java.util.List;

public class RacingGame {

    private GameIO gameIO;
    private Cars cars;
    private int turn;

    public RacingGame() {
        gameIO = new GameIO();
    }

    public void setGame() {
        String[] names = gameIO.inputCarNames();
        cars = new Cars(names);
        turn = gameIO.inputTurnNumber();
    }

    public void runGame() {
        System.out.println("실행 결과");
        for (int i = 0; i < turn; i++) {
            cars.executeTurn();
        }
    }

    public void printWinner() {
        List<String> winners = cars.getWinners();
        gameIO.printWinner(winners);
    }

    public List<Car> getCarList() {
        return cars.getCars();
    }
}
