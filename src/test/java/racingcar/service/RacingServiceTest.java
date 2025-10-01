package racingcar.service;

import org.junit.jupiter.api.Test;
import racingcar.domain.RacingResult;
import racingcar.random.StubRandomGenerator;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingServiceTest {

    @Test
    void raceProducesRoundSnapshotsAndWinners() {
        // stub generator that returns predictable sequence
        StubRandomGenerator stub = new StubRandomGenerator(new int[]{
                4, 0, 4,  // round1 for 3 cars
                4, 0, 4,  // round2
                4, 0, 4   // round3
        });

        RacingService svc = new RacingService(stub);
        RacingResult result = svc.race("pobi,woni,jun", "3");

        assertThat(result.getWinners()).contains("pobi, jun");
        assertThat(result.getRoundSnapshots().size()).isEqualTo(2);
    }
}
