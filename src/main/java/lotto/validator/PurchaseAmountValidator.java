package lotto.validator;

import lotto.message.ExceptionMessage;

public class PurchaseAmountValidator {
    private static final int LOTTO_PRICE = 1000;

    private void validate(int inputAmount) {
        validateNaturalNumber(inputAmount);
        validateDivisibleByPrice(inputAmount);
    }

    private void validateNaturalNumber(int inputAmount) {
        if (inputAmount <= 0) {
            throw new IllegalArgumentException(ExceptionMessage.NOT_NATURAL_NUMBER.getMessage());
        }
    }

    private void validateDivisibleByPrice(int inputAmount) {
        if (inputAmount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(ExceptionMessage.INDIVISIBLE_AMOUNT.getMessage());
        }
    }

}
