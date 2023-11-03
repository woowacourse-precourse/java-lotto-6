package lotto.domain;

import lotto.ErrorMessage;

public class Amount {

    public static final int dd = 1000;

    private final int amount;

    public Amount(int amount) {
        this.validateAmount(amount);
        this.amount = amount;
    }

    private void validateAmount(int amount) {
        this.validateIsDividedLottoPrice(amount);
        this.validateIsPositive(amount);
    }

    private void validateIsDividedLottoPrice(int amount) {
        if (amount % dd != 0) {
            throw new IllegalArgumentException(ErrorMessage.AMOUNT_IS_NOT_DIVIDED_LOTTO_PRICE.message());
        }
    }

    private void validateIsPositive(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException(ErrorMessage.AMOUNT_IS_NOT_POSITIVE.message());
        }
    }

    public int getPurchaseNumber() {
        return amount / dd;
    }

    @Override
    public String toString() {
        return "Amount{" +
                "amount=" + amount +
                '}';
    }
}
