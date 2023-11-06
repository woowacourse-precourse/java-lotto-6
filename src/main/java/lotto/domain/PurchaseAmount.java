package lotto.domain;

import lotto.constant.LottoConstant;

public class PurchaseAmount {
    private int amount;

    public PurchaseAmount(int amount) {
        validate(amount);
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    private void validate(int amount) {
        if (amount < LottoConstant.LOTTO_PRICE || amount % LottoConstant.LOTTO_PRICE != 0) {
            throw new IllegalArgumentException();
        }
    }
}
