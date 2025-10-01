package racingcar.util;

public class ParseInt {

    public static int parseInt(String rounds) {
        try {
            return Integer.parseInt(rounds.strip());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Rounds must be a number", e);
        }
    }
}
