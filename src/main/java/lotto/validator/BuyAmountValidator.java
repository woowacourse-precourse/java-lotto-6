package lotto.validator;

import static lotto.constants.ExceptionMessages.*;

public class BuyAmountValidator {

    private final int amount;

    public BuyAmountValidator(String amount) {
        validateBlank(amount);
        this.amount = validateAmountFormat(amount);
    }

    private int validateAmountFormat(String amountStr) {
        int amount = validateNumber(amountStr);
        validateZeroMoney(amount);
        validateRemainder(amount);
        return amount;
    }

    public int validateNumber(String amount) {
        String regex = "[0-9]+";

        if(amount.matches(regex)) {
            return Integer.parseInt(amount);
        }

        throw new IllegalArgumentException(INVALID_NUMBER_BUY_AMOUNT.getMessage());
    }

    public void validateBlank(String amount) {
        if (amount.isBlank()) {
            throw new IllegalArgumentException(INVALID_BLANK_BUY_AMOUNT.getMessage());
        }
    }

    public void validateZeroMoney(int amount) {
        if (amount == 0) {
            throw new IllegalArgumentException(INVALID_ZERO_BUY_AMOUNT.getMessage());
        }
    }

    public void validateRemainder(int amount) {
        if (amount % 1000 != 0) {
            throw  new IllegalArgumentException(INVALID_REMAINDER_NUMBER.getMessage());
        }
    }

    public int getBuyAmount() {
        return amount;
    }
}
