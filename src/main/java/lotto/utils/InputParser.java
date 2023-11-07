package lotto.utils;

import java.util.List;
import lotto.constants.Values;

public class InputParser {
    public static List<String> splitByDelimiter(String input) {
        return List.of(input.split(Values.WINNING_NUMBER_DELIMITER));
    }
}
