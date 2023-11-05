package lotto.domain;

import java.math.BigDecimal;

public class LottoPurchaseAmount {

    private final BigDecimal amount;

    public LottoPurchaseAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getAmount() {
        return this.amount;
    }

}
