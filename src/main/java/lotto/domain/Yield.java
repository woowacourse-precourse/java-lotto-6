package lotto.domain;

import java.util.Map;

import static lotto.domain.LottoMoney.MONEY_UNIT;

public class Yield {

    private static final int HUNDRED = 100;

    private final double value;

    private Yield(double yield) {
        this.value = yield;
    }

    public static Yield from(Map<Ranking, Integer> rankingInfo, int amount) {
        double sumPrize = 0;
        for (Ranking ranking : rankingInfo.keySet()) {
            double count = rankingInfo.get(ranking);
            sumPrize += ranking.multiplePrize(count);
        }
        double value = calculateYield(sumPrize, amount);
        return new Yield(value);
    }

    private static double calculateYield(double sumPrize, int amount) {
        return (sumPrize / (amount * MONEY_UNIT)) * HUNDRED;
    }

    public double getValue() {
        return value;
    }
}
