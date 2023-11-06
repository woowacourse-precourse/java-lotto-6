package lotto.domain;

import lotto.validation.Validation;

public class Buyer {

    public static final int UNIT = 1000;
    public static final int MIN_AMOUNT = 1000;
    private int purchaseAmount;

    public Buyer(int purchaseAmount) {
        validate(purchaseAmount);
        this.purchaseAmount = purchaseAmount;
    }

    private void validate(int purchaseAmount) {
        Validation.ValidateMinPurchaseAmount(purchaseAmount, MIN_AMOUNT);
        Validation.validateAmountUnit(purchaseAmount, UNIT);
    }



}
