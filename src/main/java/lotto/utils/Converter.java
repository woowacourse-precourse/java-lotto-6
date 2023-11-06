package lotto.utils;

import static java.lang.Integer.parseInt;
import static lotto.exception.ExceptionMessage.INVALID_NUMBER_ERROR;
import static lotto.validator.InputValidator.validateContainWhiteSpace;
import static lotto.validator.InputValidator.validateStringWithSeparator;
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
}
