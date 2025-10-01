package racingcar.view;

import racingcar.domain.Cars;

import java.util.List;

public class OutputView {

    public void printRound(Cars cars) {
        // 한 라운드의 스냅샷을 출력. Cars.formatRoundResult() 가 각 car: dash 형태를 반환한다.
        System.out.println(cars.formatRoundResult());
        System.out.println(); // 라운드 사이에 빈 줄 하나(가독성)
    }

    public void printWinners(List<String> winners) {
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }
}
