package lotto.model;

import static lotto.util.Constants.LOTTO_PRICE;

import lotto.message.ExceptionMessage;

public class PurchaseAmount {
    private static final int ZERO = 0;
    private static final int NO_REMAINDER = 0;

    private final int purchaseAmount;

    public PurchaseAmount(int inputAmount) {
        validate(inputAmount);
        this.purchaseAmount = inputAmount;
    }

    private void validate(int inputAmount) {
        validateNaturalNumber(inputAmount);
        validateDivisibleByPrice(inputAmount);
    }

    private void validateNaturalNumber(int inputAmount) {
        if (inputAmount <= ZERO) {
            throw new IllegalArgumentException(ExceptionMessage.NOT_NATURAL_NUMBER.getMessage());
        }
    }

    private void validateDivisibleByPrice(int inputAmount) {
        if (inputAmount % LOTTO_PRICE != NO_REMAINDER) {
            throw new IllegalArgumentException(ExceptionMessage.INDIVISIBLE_AMOUNT.getMessage());
        }
    }

    public boolean isNotFullyIssued(int count) {
        return purchaseAmount / LOTTO_PRICE != count;
    }

}
