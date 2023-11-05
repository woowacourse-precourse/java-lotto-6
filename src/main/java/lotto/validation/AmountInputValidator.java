package lotto.validation;

import static lotto.validation.enumType.AmountInput.NUMERIC_FORMAT_MESSAGE;
import static lotto.validation.enumType.AmountInput.POSITIVE_MESSAGE;

public class AmountInputValidator {

    public void validateInputNumericFormat(String input) {
        if (isNotNumericFormat(input)) {
            throw new IllegalArgumentException(NUMERIC_FORMAT_MESSAGE.getValue());
        }
    }

    private boolean isNotNumericFormat(String input) {
        return !input.chars().allMatch(Character::isDigit);
    }

    public void validatePositive(String input) {
        int amountInput = Integer.parseInt(input);
        if (isNotPositive(amountInput)) {
            throw new IllegalArgumentException(POSITIVE_MESSAGE.getValue());
        }
    }

    private boolean isNotPositive(int amountInput) {
        return amountInput < 1;
    }
}
