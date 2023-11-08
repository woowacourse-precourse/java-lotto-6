package lotto.validator;

import static lotto.constants.ExceptionMessages.*;

public record BuyAmountValidator(String amount) {
    public BuyAmountValidator {
        validateBlank(amount);
        validateNumber(amount);
        validateRemainder(Integer.parseInt(amount));
    }

    public void validateNumber(String amount) {
        String regex = "[1-9][0-9]+";

        if(amount.matches(regex)) {
            return;
        }

        throw new IllegalArgumentException(INVALID_NUMBER_BUY_AMOUNT.getMessage());
    }

    public void validateBlank(String amount) {
        if (amount.isBlank()) {
            throw new IllegalArgumentException(INVALID_BLANK_BUY_AMOUNT.getMessage());
        }
    }

    public void validateRemainder(int amount) {
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException(INVALID_REMAINDER_NUMBER.getMessage());
        }
    }
}
