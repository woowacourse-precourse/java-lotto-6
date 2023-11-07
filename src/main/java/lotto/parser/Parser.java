package lotto.parser;

import lotto.exception.ExceptionMessage;

import java.util.Arrays;
import java.util.List;

public class Parser {
    private static final String COMMA = ",";

    private Parser() {
        throw new AssertionError();
    }

    public static List<Integer> parseWinningNumbers(String winningNumbers) {
        validateBlank(winningNumbers);
        return Arrays.stream(winningNumbers.split(COMMA))
                .map(String::trim)
                .map(Parser::parseStrToInt)
                .toList();
    }

    public static int parseStrToInt(String input) {
        try {
            validateBlank(input);
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw ExceptionMessage.INPUT_NUMBER_FORMAT.getException();
        }
    }

    private static void validateBlank(String inputValue) {
        if (inputValue == null || inputValue.isBlank()) {
            throw ExceptionMessage.INPUT_BLANK.getException();
        }
    }
}
