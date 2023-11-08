package lotto.validator;

import static lotto.constants.ExceptionMessages.INVALID_NUMBER_RANGE;
import static lotto.constants.ExceptionMessages.NOT_ALLOWED_BLANK_NUMBER;

public record BonusNumberValidator(String number) {
    public BonusNumberValidator {
        validateBlank(number);
        validateNumber(number);
    }

    public void validateNumber(String number) {
        String regex = "([1-9]|[1-4][0-5])";
        if (number.matches(regex)) {
            return;
        }
        throw new IllegalArgumentException(INVALID_NUMBER_RANGE.getMessage());
    }

    public void validateBlank(String number) {
        if (number.isBlank()) {
            throw new IllegalArgumentException(NOT_ALLOWED_BLANK_NUMBER.getMessage());
        }
    }
}
