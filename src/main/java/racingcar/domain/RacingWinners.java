package racingcar.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class RacingWinners {
    private final List<Car> cars;

    private RacingWinners(List<Car> cars) {
        this.cars = Collections.unmodifiableList(cars);
    }

    public static RacingWinners of(List<Car> carList) {
        return new RacingWinners(carList);
    }

    public List<String> getWinnerNames() {
        int winnerDistance = findWinnerDistance();
        return findWinnerNames(winnerDistance);
    }

    // 승자의 거리를 찾는 메서드
    private int findWinnerDistance() {
        return cars.stream()
                .mapToInt(Car::getDistance)
                .max()
                .orElse(0);
    }

    // 승자의 이름을 찾는 메서드
    private List<String> findWinnerNames(int winnerDistance) {
        return cars.stream()
                .filter(car -> car.isWinner(winnerDistance))
                .map(Car::getName)
                .collect(Collectors.toList());
    }
}
