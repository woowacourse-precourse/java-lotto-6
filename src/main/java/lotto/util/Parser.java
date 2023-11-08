package lotto.util;

import java.util.Arrays;
import java.util.List;

public class Parser {

    private static final String DELIMITER = ",";

    private Parser() {
    }

    public static List<Integer> stringToIntList(String input) {
        return Arrays.stream(input.split(DELIMITER))
                .map(Integer::parseInt)
                .toList();
    }

    public static List<String> stringToList(String input) {
        return Arrays.asList(input.split(DELIMITER));
    }
}
