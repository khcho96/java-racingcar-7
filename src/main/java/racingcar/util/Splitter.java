package racingcar.util;

import java.util.Arrays;
import java.util.List;

public class Splitter {
    public static List<String> split(String string) {
        return Arrays.stream(string.split(","))
                .map(String::strip)
                .filter(s -> !s.isBlank())
                .toList();
    }
}
