package racingcar;

import racingcar.controller.RacingController;
import racingcar.service.RacingService;
import racingcar.random.RealRandomGenerator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        new RacingController(new InputView(), new OutputView(), new RacingService(new RealRandomGenerator())).run();
    }
}
