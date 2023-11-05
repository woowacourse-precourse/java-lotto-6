package lotto.validation;

import static lotto.validation.enumType.AmountInput.NUMERIC_FORMAT_MESSAGE;

public class AmountInputValidator {

    public void validateInputNumericFormat(String input) {
        if (isNotNumericFormat(input)) {
            throw new IllegalArgumentException(NUMERIC_FORMAT_MESSAGE.getValue());
        }
    }

    private boolean isNotNumericFormat(String input) {
        return !input.chars().allMatch(Character::isDigit);
    }
}
