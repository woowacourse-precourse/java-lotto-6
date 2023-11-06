package lotto.domain;

import java.math.BigDecimal;

public class LottoPurchaseAmount {

    public static final int AMOUNT_CLASSIFICATION_THRESHOLD = 1000;

    private final BigDecimal amount;

    public LottoPurchaseAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public int calculatePurchasableQuantity() {
        return this.amount.intValue() / AMOUNT_CLASSIFICATION_THRESHOLD;
    }

    public BigDecimal getAmount() {
        return this.amount;
    }

}
