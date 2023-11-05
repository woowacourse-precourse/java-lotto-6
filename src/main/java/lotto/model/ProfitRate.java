package lotto.model;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ProfitRate {
    private final Money money;
    private final BigDecimal reward;

    public ProfitRate(Money money, BigDecimal reward) {
        this.money = money;
        this.reward = reward;
    }

    public String getProfitRate() {
        BigDecimal money = BigDecimal.valueOf(this.money.getMoney()).divide(BigDecimal.valueOf(100));

        BigDecimal div = this.reward.divide(money, 1, RoundingMode.HALF_UP);

        return String.format("%s%%", div);
    }
}
