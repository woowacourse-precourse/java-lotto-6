package lotto.model;

import lotto.constant.LottoConstant;

public record Capital(int amount) {
    public Capital {
        validate(amount);
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
