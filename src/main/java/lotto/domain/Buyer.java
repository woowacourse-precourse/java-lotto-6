package lotto.domain;

import lotto.validator.BuyerValidator;

public class Buyer {
    private final int purchasePrice;

    public Buyer(int purchasePrice) {
        BuyerValidator.validatePurchasePrice(purchasePrice);
        this.purchasePrice = purchasePrice;
    }
}
