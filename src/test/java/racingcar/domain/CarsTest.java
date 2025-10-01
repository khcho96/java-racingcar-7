package racingcar.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {

    @Test
    void formatRoundResultShowsDashesAccordingToPosition() {
        Cars cars = Cars.of(List.of("pobi", "jun"));
        // apply randoms for test convenience:
        cars.applyRandoms(List.of(4, 3)); // pobi moves, jun not
        String s = cars.formatRoundResult();
        assertThat(s.contains("pobi : -")).isEqualTo(true);
        assertThat(s.contains("jun : ")).isEqualTo(true);
    }
}
