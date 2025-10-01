package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.domain.RacingResult;
import racingcar.service.RacingService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {

    private final InputView input;
    private final OutputView output;
    private final RacingService service;

    public RacingController(InputView input, OutputView output, RacingService service) {
        this.input = input;
        this.output = output;
        this.service = service;
    }

    public void run() {
        String names = input.readCarNames();
        String rounds = input.readRounds();

        RacingResult result = service.race(names, rounds);

        // print each round snapshot
        for (Cars snapshot : result.getRoundSnapshots()) {
            output.printRound(snapshot);
        }
        // print winners
        output.printWinners(result.getWinners());
    }
}
