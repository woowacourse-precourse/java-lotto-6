package lotto.model;

import lotto.constant.LottoConstant;

public class Money {
    private final int amount;

    public Money(int amount) {
        validate(amount);
        this.amount = amount;
    }

    private void validate(int amount) {
        if (amount > LottoConstant.MAX_PURCHASE_AMOUNT || amount <= 0) {
            throw new IllegalArgumentException();
        }

        if (amount % 1000 != 0) {
            throw new IllegalArgumentException();
        }
    }

    public int getNumberOfPurchasedLotto() {
        return amount / 1000;
    }
}
