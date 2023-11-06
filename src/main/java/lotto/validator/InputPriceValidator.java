package lotto.validator;

import lotto.exception.LottoException;
import lotto.exception.constant.ErrorMessage;

public class InputPriceValidator {
    private static final String DELIMITER = ",";
    private InputPriceValidator() {
    }
    private static void validateEndsWithComma(final String input) {
        if (input.endsWith(DELIMITER)) {
            throw LottoException.of(ErrorMessage.INVALID_INPUT);
        }
    }
    private static void validateEmpty(final String input) {
        if (input.isEmpty()) {
            throw LottoException.of(ErrorMessage.EMPTY);
        }
    }
    private static void validatePriceRange(final int price) {
        if (price < 0) {
            throw LottoException.of(ErrorMessage.INVALID_PRICE_RANGE);
        }
    }
    private static void validatePriceFormat(final int number) {
        if(number % 1000 != 0) {
            throw LottoException.of(ErrorMessage.INVALID_INPUT_PRICE);
        }
    }
    private static void validatePriceIsNumeric(final String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw LottoException.of(ErrorMessage.INVALID_NUMBER);
        }
    }
    public static void validatePrice(final String input) {
        validateEmpty(input);
        validateEndsWithComma(input);
        validatePriceIsNumeric(input);
        validatePriceFormat(Integer.parseInt(input));
        validatePriceRange(Integer.parseInt(input));
    }

}
