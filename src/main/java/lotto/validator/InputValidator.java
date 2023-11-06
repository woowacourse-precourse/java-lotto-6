package lotto.validator;

import static lotto.exception.ExceptionMessage.EMPTY_INPUT_ERROR;
import static lotto.exception.ExceptionMessage.HAS_BOTH_ENDS_SEPARATOR;
import static lotto.view.SeparatorConstant.WINNING_NUMBERS_SEPARATOR;

import lotto.exception.LottoGameException;

public class InputValidator {
    
    public static void validateStringWithSeparator(final String input) {
        if (hasStartSeparator(input) || hasEndSeparator(input)) {
            throw LottoGameException.from(HAS_BOTH_ENDS_SEPARATOR);
        }
    }
    
    private static boolean hasEndSeparator(final String input) {
        return input.endsWith(WINNING_NUMBERS_SEPARATOR);
    }
    
    private static boolean hasStartSeparator(final String input) {
        return input.startsWith(WINNING_NUMBERS_SEPARATOR);
    }
    
    public static void validateContainWhiteSpace(final String input) {
        if (hasWhiteSpace(input)) {
            throw LottoGameException.from(EMPTY_INPUT_ERROR);
        }
    }
    
    private static boolean hasWhiteSpace(final String input) {
        return input.chars()
                .anyMatch(Character::isWhitespace);
    }
}
