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
        if (amount % dd != 0) {
            throw new IllegalArgumentException(ErrorMessage.AMOUNT_DIVIDED_LOTTO_PRICE.message());
        }
    }

    public int getPurchaseNumber() {
        return amount / dd;
    }
}
