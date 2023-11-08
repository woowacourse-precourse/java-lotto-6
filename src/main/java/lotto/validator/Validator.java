package lotto.validator;

import lotto.domain.constants.LottoConstraint;
import lotto.domain.message.ErrorMessage;

public class Validator {
    public static void validateNumber(final String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw ErrorMessage.INVALID_NUMBER_FORMAT.createException();
        }
    }

    public static void validateRange(final int number) {
        if (number < LottoConstraint.MIN_NUMBER.getValue() || number > LottoConstraint.MAX_NUMBER.getValue()) {
            throw ErrorMessage.OUT_OF_RANGE.createException();
        }
    }
}
