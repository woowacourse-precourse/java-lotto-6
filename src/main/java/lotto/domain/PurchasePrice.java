package lotto.domain;

import lotto.exception.ErrorCode;

public class PurchasePrice {

    private static final int LOTTO_UNIT = 1000;

    private final int purchasePrice;


    public PurchasePrice(int purchasePrice) {
        validate(purchasePrice);
        this.purchasePrice = purchasePrice;
    }

    private void validate(int purchasePrice) {
        if (purchasePrice % LOTTO_UNIT != 0) {
            throw new IllegalArgumentException(ErrorCode.INCORRECT_UNIT.getMessage());
        }
    }

    public int getPurchasePrice() {
        return purchasePrice;
    }
}
