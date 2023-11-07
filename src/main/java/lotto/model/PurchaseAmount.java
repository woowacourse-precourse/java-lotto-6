package lotto.model;

import static lotto.util.Constants.LOTTO_PRICE;

import lotto.message.ExceptionMessage;

public class PurchaseAmount {
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
        if (inputAmount <= 0) {
            throw new IllegalArgumentException(ExceptionMessage.NOT_NATURAL_NUMBER.getMessage());
        }
    }

    private void validateDivisibleByPrice(int inputAmount) {
        if (inputAmount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(ExceptionMessage.INDIVISIBLE_AMOUNT.getMessage());
        }
    }

    public boolean isNotFullyIssued(int count) {
        return purchaseAmount / LOTTO_PRICE != count;
    }

}
