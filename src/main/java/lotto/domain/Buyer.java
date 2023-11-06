package lotto.domain;

import static lotto.domain.constants.LottoConfig.LOTTO_COUNT;
import static lotto.domain.constants.LottoConfig.LOTTO_UNIT_PRICE;

import lotto.validator.BuyerPurchaseAmountValidator;

public class Buyer {
    private final int purchaseAmount;

    private Buyer(String purchaseAmount) {
        new BuyerPurchaseAmountValidator().validate(purchaseAmount);
        this.purchaseAmount = Integer.valueOf(purchaseAmount);
        LOTTO_COUNT.setValue(this.purchaseAmount / LOTTO_UNIT_PRICE.getValue());
    }

    public static Buyer createBuyer(String purchaseAmount) {
        return new Buyer(purchaseAmount);
    }

}
