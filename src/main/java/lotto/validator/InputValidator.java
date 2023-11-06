package lotto.validator;

import static lotto.enums.ErrorMassage.IS_BLANK;

public class InputValidator {

    public void validateBlank(final String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException(IS_BLANK.getMassage());
        }
    }
}
