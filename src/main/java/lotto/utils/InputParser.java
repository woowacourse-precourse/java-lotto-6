package lotto.utils;

import java.util.List;

public class InputParser {

    private static final String WINNING_NUMBER_DELIMITER = ",";

    public static List<String> splitByDelimiter(String input) {
        return List.of(input.split(WINNING_NUMBER_DELIMITER));
    }
}
