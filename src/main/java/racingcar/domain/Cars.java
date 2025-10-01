package racingcar.domain;

import racingcar.random.RandomGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> cars;

    private Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars of(List<String> names) {
        List<Car> carList = names.stream().
                map(Car::new).
                toList();
        return new Cars(carList);
    }

    public Cars clone() {
        List<Car> carsClone = new ArrayList<>();
        for (Car car : cars) {
            carsClone.add(new Car(car.getName(), car.getPosition()));
        }
        return new Cars(carsClone);
    }

    public void startRace(RandomGenerator randomGenerator) {
        for (Car car : cars) {
            int rnd = randomGenerator.nextInt();
            car.moveIf(rnd);
        }
    }

    private int getWinnerPosition() {
        return cars
                .stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
    }

    public List<String> getWinners() {
        int max = getWinnerPosition();

        return cars
                .stream()
                .filter(c -> c.getPosition() == max)
                .map(Car::getName)
                .toList();
    }

    // For Test
    public void applyRandoms(List<Integer> random) {
        for (int i = 0; i < cars.size(); i++) {
            cars.get(i).moveIf(random.get(i));
        }
    }

    public String formatRoundResult() {
        return cars.stream()
                .map(car -> car.getName() + " : " + "-".repeat(car.getPosition()))
                .collect(Collectors.joining(System.lineSeparator()));
    }

    public List<Car> getCars() {
        return cars;
    }
}
