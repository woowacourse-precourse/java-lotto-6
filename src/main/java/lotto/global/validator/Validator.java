package lotto.global.validator;

import lotto.global.exception.ErrorMessage;
import lotto.global.exception.LottoException;

public final class Validator {
    public static void validateNumber(final String message) {
        if (isNotNumber(message)) {
            throw LottoException.from(ErrorMessage.NOT_NUMBER_ERROR);
        }
    }

    private static boolean isNotNumber(final String message) {
        return !message.matches("\\d+");
    }
}
