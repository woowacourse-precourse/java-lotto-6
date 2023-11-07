package lotto.domain;

import static lotto.constants.Constants.Integers.LOTTO_PRICE;

public class PurchaseQuantity {

    private final int purchaseQuantity;

    public PurchaseQuantity(int budget) {
        this.purchaseQuantity = budget / LOTTO_PRICE.getValue();
    }

    public int getPurchaseQuantity() {
        return purchaseQuantity;
    }

    @Override
    public String toString() {
        return String.valueOf(purchaseQuantity);
    }
}
