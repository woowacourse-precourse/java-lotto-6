package lotto.controller;

import lotto.utils.Constants;
import lotto.utils.ErrorConstants;

public class Validator {
    void validateBlankInput(final String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException(ErrorConstants.INPUT_BLANK);
        }
    }

    void validateNumberFormat(final String input) {
        if (!input.matches(Constants.NUMBER_INPUT_REGEX)) {
            throw new IllegalArgumentException(ErrorConstants.NUMBER_FORMAT);
        }
    }
}