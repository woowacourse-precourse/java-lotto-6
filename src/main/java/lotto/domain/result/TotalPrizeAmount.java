package lotto.domain.result;

import java.math.BigDecimal;

public class TotalPrizeAmount {

    private final BigDecimal amount;

    public TotalPrizeAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getAmount() {
        return this.amount;
    }

}
