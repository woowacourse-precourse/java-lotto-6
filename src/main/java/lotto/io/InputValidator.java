package lotto.io;

import lotto.constant.ErrorMessage;

public class InputValidator {

    public void validatePurchaseAmount(final String input) {
        if (isNotNumeric(input)) {
            throw new IllegalArgumentException(ErrorMessage.NOT_NUMBER.toValue());
        }
    }

    private boolean isNotNumeric(final String input) {
        return !input.chars().allMatch(Character::isDigit);
    }
}
