package lotto.domain.validator;

import lotto.exception.LottoException;

import static lotto.exception.ErrorMessage.EMPTY_REQUEST;

public class InputValidator {
    private InputValidator() {
    }

    public static void validateEmpty(final String input) {
        if (input.isEmpty()) {
            throw LottoException.from(EMPTY_REQUEST);
        }
    }
}
