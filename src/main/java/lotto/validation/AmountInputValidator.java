package lotto.validation;

import static lotto.validation.enumType.AmountInput.NUMERIC_FORMAT_MESSAGE;
import static lotto.validation.enumType.AmountInput.ONE_LOTTO_PRICE;
import static lotto.validation.enumType.AmountInput.POSITIVE_MESSAGE;
import static lotto.validation.enumType.AmountInput.VALUE_DIVIDE_MESSAGE;

public class AmountInputValidator {

    public void validateInputNumericFormat(String input) {
        if (isNotNumericFormat(input)) {
            throw new IllegalArgumentException(NUMERIC_FORMAT_MESSAGE.getMessage());
        }
    }

    private boolean isNotNumericFormat(String input) {
        return !input.chars().allMatch(Character::isDigit);
    }

    public void validatePositive(String input) {
        int amountInput = Integer.parseInt(input);
        if (isNotPositive(amountInput)) {
            throw new IllegalArgumentException(POSITIVE_MESSAGE.getMessage());
        }
    }

    private boolean isNotPositive(int amountInput) {
        return amountInput < 1;
    }

    public void validateDivisibilityBy1000(String input) {
        int amountInput = Integer.parseInt(input);
        if (isNotValueDivisibleBy1000(amountInput)) {
            throw new IllegalArgumentException(VALUE_DIVIDE_MESSAGE.getMessage());
        }
    }

    private boolean isNotValueDivisibleBy1000(int amountInput) {
        return !(amountInput % ONE_LOTTO_PRICE.getNumber() == 0);
    }
}
