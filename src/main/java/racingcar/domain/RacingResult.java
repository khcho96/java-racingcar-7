package racingcar.domain;

import java.util.List;

public class RacingResult {
    private final List<Cars> roundSnapshots; // snapshots after each round
    private final List<String> winners;

    public RacingResult(List<Cars> roundSnapshots, List<String> winners) {
        this.roundSnapshots = roundSnapshots;
        this.winners = winners;
    }

    public List<Cars> getRoundSnapshots() {
        return roundSnapshots;
    }

    public List<String> getWinners() {
        return winners;
    }
}
