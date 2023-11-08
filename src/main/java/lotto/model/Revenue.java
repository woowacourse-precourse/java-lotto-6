package lotto.model;

import java.util.Map;

public class Revenue {

    private static final int HUNDRED = 100;

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
        return (sumPrize / (amount * 1000)) * HUNDRED;
    }

    public double getValue() {
        return value;
    }
}