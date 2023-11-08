package lotto.validator;

import static lotto.enums.ErrorMessage.CONTAIN_SPACE;
import static lotto.enums.ErrorMessage.IS_BLANK;

public class InputValidator {
    private static final String SPACE = " ";

    public void validate(final String input) {
        validateBlank(input);
        validateContainSpace(input);
    }

    private void validateBlank(final String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException(IS_BLANK.getMassage());
        }
    }

    private void validateContainSpace(final String input) {
        if (input.contains(SPACE)) {
            throw new IllegalArgumentException(CONTAIN_SPACE.getMassage());
        }
    }
}
