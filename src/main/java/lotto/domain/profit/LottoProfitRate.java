package lotto.domain.profit;

import java.math.BigDecimal;

public class LottoProfitRate {

    private final BigDecimal rate;

    public LottoProfitRate(BigDecimal rate) {
        this.rate = rate;
    }

    public BigDecimal getRate() {
        return this.rate;
    }

}
