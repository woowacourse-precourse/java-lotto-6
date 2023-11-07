package lotto.domain;

import lotto.exception.ErrorCode;

public class PurchasePrice {
    private final int purchasePrice;

    public PurchasePrice(int purchasePrice) {
        validate(purchasePrice);
        this.purchasePrice = purchasePrice;
    }

    private void validate(int purchasePrice) {
        if (purchasePrice % 1000 != 0) {
            throw new IllegalArgumentException(ErrorCode.INCORRECT_UNIT.getMessage());
        }
    }

    public int getPurchasePrice() {
        return purchasePrice;
    }
}
