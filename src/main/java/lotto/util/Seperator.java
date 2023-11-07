package lotto.util;

import java.util.Arrays;
import java.util.List;

public class Seperator {
    public static final String WINNING_NUMBERS_SEPARATOR = ",";

    public static List<String> split(String seperator, String input) {
        return Arrays.asList(input.split(seperator));
    }

    private Seperator() {
    }
}
