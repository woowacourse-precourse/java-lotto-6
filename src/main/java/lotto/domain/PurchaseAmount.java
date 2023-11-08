package lotto.domain;

import lotto.constant.ErrorMessage;

public class PurchaseAmount {

    private int amount;

    public PurchaseAmount(int amount) {
        validateDivideLottoPrice();
        this.amount = amount;
    }
    private void validateDivideLottoPrice() {
        if (divideLottoPrice(amount)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_PURCHASE_AMOUNT.getMessage());
        }
    }
    private boolean divideLottoPrice(int amount) {
        return (amount % 1000) != 0;
    }

    public int getAmount() {
        return amount;
    }
}
