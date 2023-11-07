package lotto.utils;

import java.util.Arrays;
import java.util.List;

import static lotto.exception.ErrorMessage.*;

public class Parser {
    private static final String DELIMITER = ",";

    public static int parsePay(String input) {
        return parseIntegerFromString(input, INVLID_PAYMENT_TYPE.getMessage());
    }

    public static List<Integer> parseWinningNumber(String input) {
        validateEndsWithDelimiter(input);

        List<Integer> numbers = Arrays
                .stream(input.split(DELIMITER))
                .map(number -> parseIntegerFromString(number, INVALID_WINNING_NUMBER_FORM.getMessage()))
                .toList();

        return numbers;
    }

    public static int parseBonusNumber(String input) {
        return parseIntegerFromString(input, INVALID_BONUS_NUMBER_FORM.getMessage());
    }

    private static int parseIntegerFromString(String input, String errorMessage) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(errorMessage);
        }
    }

    private static void validateEndsWithDelimiter(String input) {
        if (input.endsWith(DELIMITER)) {
            throw new IllegalArgumentException(WINNING_NUMBER_ENDS_WITH_DELIMITER.getMessage());
        }
    }
}
