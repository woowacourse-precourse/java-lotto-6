package lotto.model.calculator;

import java.util.Map;
import lotto.constant.UnitNumber;
import lotto.constant.Winning;

public class YieldCalculator {
    private static double rateOfReturn;

    public YieldCalculator(int totalPurchaseAmount, Map<Winning, Integer> prize) {
        int sumPrize = UnitNumber.ZERO.getNumber();
        for(Winning rank : Winning.values()) {
            sumPrize += prize.get(rank) * rank.getMoney();
        }
        rateOfReturn = ((double)sumPrize / totalPurchaseAmount) * UnitNumber.PERCENTAGE.getNumber();
    }

    public double getRateOfReturn() {
        return rateOfReturn;
    }
}
