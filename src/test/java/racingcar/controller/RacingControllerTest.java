package racingcar.controller;

import org.junit.jupiter.api.Test;
import racingcar.domain.Cars;
import racingcar.service.RacingService;
import racingcar.random.StubRandomGenerator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class RacingControllerTest {

    @Test
    void controllerRunsFullFlowAndPrintsRoundsAndWinners() {
        InputView input = new InputView() {
            @Override public String readCarNames() { return "pobi,woni,jun"; }
            @Override public String readRounds() { return "3"; }
        };

        List<String> printedWinners = new ArrayList<>();
        List<Cars> printedRounds = new ArrayList<>();
        OutputView output = new OutputView() {
            @Override public void printRound(Cars cars) {
                printedRounds.add(cars);
            }
            @Override public void printWinners(List<String> winners) {
                printedWinners.addAll(winners);
            }
        };

        // stub that gives predictable results
        StubRandomGenerator stub = new StubRandomGenerator(new int[]{4,0,4, 4,0,4, 4,0,4});
        RacingService svc = new RacingService(stub);
        RacingController controller = new RacingController(input, output, svc);

        controller.run();

        assertThat(printedRounds).isNotEmpty();
        assertThat(printedWinners).contains("pobi");
        assertThat(printedWinners).contains("jun");
    }
}
