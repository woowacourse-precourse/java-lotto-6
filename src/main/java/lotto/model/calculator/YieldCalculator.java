package lotto.model.calculator;

import java.util.Map;
import lotto.constant.Winning;

public class YieldCalculator {
    private static double rateOfReturn;

    public YieldCalculator(int totalPurchaseAmount, Map<Winning, Integer> prize) {
        int sumPrize = 0;
        for(Winning rank : Winning.values()) {
            sumPrize += prize.get(rank) * rank.getMoney();
        }
        rateOfReturn = ((double)sumPrize / totalPurchaseAmount) * 100;
    }

    public double getRateOfReturn() {
        return rateOfReturn;
    }
}
