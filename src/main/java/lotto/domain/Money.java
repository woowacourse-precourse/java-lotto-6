package lotto.domain;

import lotto.util.ErrorMessage;

public record Money(int amount) {

    private static final int MIN_PURCHASE_AMOUNT = 1_000;
    private static final int MAX_PURCHASE_AMOUNT = 100_000;
    private static final int AMOUNT_MULTIPLE_UNIT = 1_000;

    public Money {
        validateMinimumAmount(amount);
        validateMaximumAmount(amount);
        validateAmountMultipleOfThousand(amount);
    }

    public Money(String amount) {
        this(parseAmount(amount));
    }

    private static int parseAmount(String amount) {
        try {
            return Integer.parseInt(amount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT_PURCHASE_AMOUNT.getMessage());
        }
    }

    private void validateMinimumAmount(int amount) {
        if (amount < MIN_PURCHASE_AMOUNT) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_AMOUNT_LESS_THAN_MINIMUM.getMessage());
        }
    }

    private void validateMaximumAmount(int amount) {
        if (amount > MAX_PURCHASE_AMOUNT) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_AMOUNT_GREATER_THAN_MAXIMUM.getMessage());
        }
    }

    private void validateAmountMultipleOfThousand(int amount) {
        if (amount % AMOUNT_MULTIPLE_UNIT != 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_AMOUNT_MULTIPLE_OF_THOUSAND.getMessage());
        }
    }
}
