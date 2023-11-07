package lotto.domain.caclulator;

import lotto.domain.LottoConfig;
import lotto.domain.model.Money;

public class RevenueCalculator {


    public static double calculateRevenueRate(long totalEarnings, Money money) {
        if (money.getAmount() == LottoConfig.ZERO.getValue()) {
            return LottoConfig.ZERO.getValue();
        }

        return (double) totalEarnings / money.getAmount() * LottoConfig.PROFIT_RATE_BASE.getValue();
    }

}
