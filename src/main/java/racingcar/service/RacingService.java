package racingcar.service;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.RacingResult;
import racingcar.random.RandomGenerator;

import java.util.ArrayList;
import java.util.List;

import static racingcar.util.ParseInt.parseInt;
import static racingcar.util.Splitter.split;
import static racingcar.util.Validator.*;

public class RacingService {

    private final RandomGenerator randomGenerator;

    public RacingService(RandomGenerator randomGenerator) {
        this.randomGenerator = randomGenerator;
    }

    public RacingResult race(String nameCsv, String InputRounds) {
        int rounds = parseInt(InputRounds);
        validateRounds(rounds);

        List<String> names = split(nameCsv);
        validateNameEmpty(names);

        Cars cars = Cars.of(names);

        List<Cars> snapshots = getSnapshots(rounds, cars);
        List<String> winners = cars.getWinners();

        return new RacingResult(snapshots, winners);
    }

    private List<Cars> getSnapshots(int rounds, Cars cars) {
        List<Cars> snapshots = new ArrayList<>();
        for (int r = 0; r < rounds; r++) {
            cars.startRace(randomGenerator);

            Cars carsClone = cars.clone();
            snapshots.add(carsClone);
        }
        return snapshots;
    }
}