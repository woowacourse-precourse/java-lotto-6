package lotto.domain;

import lotto.constants.ErrorMessage;

public class LottoPurchase {
    private static final int LOTTO_PER_PRICE = 1000;

    private final int amount;

    public LottoPurchase(int amount) {
        validatePositiveNumber(amount);
        validateUnitAmount(amount);
        this.amount = amount;
    }

    public int getPurchaseAmount() {
        return amount / LOTTO_PER_PRICE;
    }

    private static void validatePositiveNumber(int amount) {
        if(amount <= 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_POSITIVE_NUMBER);
        }
    }

    private static void validateUnitAmount(int amount) {
        if(amount % LOTTO_PER_PRICE != 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_HUNDRED_UNIT_AMOUNT);
        }
    }

    public int getAmount() {
        return amount;
    }
}
