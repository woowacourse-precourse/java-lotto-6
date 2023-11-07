package lotto.domain;

import lotto.ErrorMessage;

public class Amount {

    private static final int MAX_PURCHASE = 1000000;
    public static final int LOTTO_PRICE = 1000;

    private final int amount;

    public Amount(int amount) {
        this.validateAmount(amount);
        this.amount = amount;
    }

    private void validateAmount(int amount) {
        this.validateIsDividedLottoPrice(amount);
        this.validateIsPositive(amount);
        this.validateIsMax(amount);
    }

    private void validateIsDividedLottoPrice(int amount) {
        if (amount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(ErrorMessage.AMOUNT_IS_NOT_DIVIDED_LOTTO_PRICE.message());
        }
    }

    private void validateIsPositive(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException(ErrorMessage.AMOUNT_IS_NOT_POSITIVE.message());
        }
    }

    private void validateIsMax(int amount) {
        if (amount > MAX_PURCHASE) {
            throw new IllegalArgumentException(ErrorMessage.AMOUNT_OUT_OF_BOUND.message());
        }
    }

    public int getPurchaseNumber() {
        return amount / LOTTO_PRICE;
    }

    public int getAmount() {
        return amount;
    }
}
