package lotto.model;

import static lotto.constant.Constants.HUNDRED;
import static lotto.constant.Constants.LOTTO_PRICE;

import java.util.Map;

public class Revenue {

    private final double value;

    private Revenue(double revenue) {
        this.value = revenue;
    }

    public static Revenue from(Map<Ranking, Integer> rankingInfo, int amount) {
        double sumPrize = 0;
        for (Ranking ranking : rankingInfo.keySet()) {
            double count = rankingInfo.get(ranking);
            sumPrize += ranking.multiplePrize(count);
        }
        double value = calculateRevenue(sumPrize, amount);
        return new Revenue(value);
    }

    private static double calculateRevenue(double sumPrize, int amount) {
        return (sumPrize / (amount * LOTTO_PRICE)) * HUNDRED;
    }

    public double getValue() {
        return value;
    }
}