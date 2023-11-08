package lotto.domain.validate;

import lotto.domain.validate.exception.InputException;

public class InputValidator {
    public void validatePurchaseAmount(String input) {
        int intInput = parseInt(input);
        isInMoneyRange(intInput);
        isDivided(intInput);
    }

    private int parseInt(String input) {
        int intInput;
        try {
            intInput = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(InputException.NO_NUMBER.getMessage());
        }
        return intInput;
    }

    private void isDivided(int intInput) {
        if ((intInput % 1000) != 0) {
            throw new IllegalArgumentException(InputException.NOT_DIVIDED_BY_1000.getMessage());
        }
    }

    private void isInMoneyRange(int intInput) {
        if (intInput < 1000 || intInput >= 100000) {
            throw new IllegalArgumentException(InputException.NOT_IN_RANGE_MONEY.getMessage());
        }
    }
}
