package racingcar.util;

import java.util.List;

public class Validator {
    public static void validateRounds(int rounds) {
        if (rounds <= 0) {
            throw new IllegalArgumentException("rounds must be positive");
        }
    }

    public static void validateInputEmpty(String input) {
        if (input == null || input.isBlank()) {

        }
    }

    public static void validateNameEmpty(List<String> names) {
        if (names.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름을 하나 이상 입력하세요.");
        }
    }
}
