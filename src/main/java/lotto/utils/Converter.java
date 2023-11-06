package lotto.utils;

import static java.lang.Integer.parseInt;
import static lotto.exception.ExceptionMessage.EMPTY_INPUT_ERROR;
import static lotto.exception.ExceptionMessage.HAS_BOTH_ENDS_SEPARATOR;
import static lotto.exception.ExceptionMessage.INVALID_NUMBER_ERROR;
import static lotto.view.SeparatorConstant.WINNING_NUMBERS_SEPARATOR;

import java.util.Arrays;
import java.util.List;
import lotto.exception.LottoGameException;

public class Converter {
    
    private Converter() {
    }
    
    public static int convertToInt(final String input) {
        try {
            validateContainWhiteSpace(input);
            return parseInt(input);
        } catch (NumberFormatException exception) {
            throw LottoGameException.of(INVALID_NUMBER_ERROR, exception);
        }
    }
    
    public static List<Integer> splitBySeparator(final String input) {
        try {
            validateContainWhiteSpace(input);
            validateStringWithSeparator(input);
            return Arrays.stream(input.split(WINNING_NUMBERS_SEPARATOR))
                    .map(Integer::parseInt)
                    .toList();
        } catch (NumberFormatException exception) {
            throw LottoGameException.of(INVALID_NUMBER_ERROR, exception);
        }
    }
    
    private static void validateStringWithSeparator(String input) {
        if (hasStartSeparator(input) || hasEndSeparator(input)) {
            throw LottoGameException.from(HAS_BOTH_ENDS_SEPARATOR);
        }
    }
    
    private static boolean hasEndSeparator(String input) {
        return input.endsWith(WINNING_NUMBERS_SEPARATOR);
    }
    
    private static boolean hasStartSeparator(String input) {
        return input.startsWith(WINNING_NUMBERS_SEPARATOR);
    }
    
    private static void validateContainWhiteSpace(String input) {
        if (hasWhiteSpace(input)) {
            throw LottoGameException.from(EMPTY_INPUT_ERROR);
        }
    }
    
    private static boolean hasWhiteSpace(String input) {
        return input.chars()
                .anyMatch(Character::isWhitespace);
    }
}
