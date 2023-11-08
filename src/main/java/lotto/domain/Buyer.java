package lotto.domain;

import static lotto.domain.constants.LottoConfig.LOTTO_UNIT_PRICE;

import lotto.validator.BuyerPurchaseAmountValidator;

public class Buyer {
    private final int purchaseCount;

    private Buyer(final String purchaseAmount) {
        new BuyerPurchaseAmountValidator().validate(purchaseAmount);
        this.purchaseCount = Integer.parseInt(purchaseAmount) / LOTTO_UNIT_PRICE.getValue();
    }

    public static Buyer of(final String purchaseAmount) {
        return new Buyer(purchaseAmount);
    }

    public int getPurchaseCount() {
        return this.purchaseCount;
    }
}
