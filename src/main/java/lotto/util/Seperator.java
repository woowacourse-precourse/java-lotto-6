package lotto.util;

import java.util.Arrays;
import java.util.List;

public enum Seperator {
    WINNING_NUMBERS_SEPARATOR(",", "쉼표");

    private final String seperator;
    private final String name;

    Seperator(String seperator, String name) {
        this.seperator = seperator;
        this.name = name;
    }

    public List<String> split(String input) {
        return Arrays.asList(input.split(seperator));
    }

    public String getSeperator() {
        return seperator;
    }

    public String getName() {
        return name;
    }
}
