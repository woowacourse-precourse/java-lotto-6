package lotto.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.message.ExceptionMessage;

public class Parser {
    private static final String SEPARATOR = ",";

    public static int parseInputToNumber(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ExceptionMessage.INPUT_NOT_NUMBER.getMessage());
        }
    }

    public static List<Integer> parseInputToList(String numbers) {
        if (!numbers.contains(SEPARATOR)) {
            throw new IllegalArgumentException(ExceptionMessage.NOT_DIVIDED_BY_COMMA.getMessage());
        }
        return Arrays.stream(numbers.split(SEPARATOR))
                .map(String::trim)
                .map(Parser::parseInputToNumber)
                .collect(Collectors.toList());
    }

}
