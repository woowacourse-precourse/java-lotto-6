package lotto.validator;

import static lotto.enums.ErrorMassage.CONTAIN_SPACE;
import static lotto.enums.ErrorMassage.IS_BLANK;

public class InputValidator {
    private static final String SPACE = " ";

    public void validateBlank(final String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException(IS_BLANK.getMassage());
        }
    }

    public void validateContainSpace(final String input) {
        if (input.contains(SPACE)) {
            throw new IllegalArgumentException(CONTAIN_SPACE.getMassage());
        }
    }
}
