package lotto.domain;

import java.text.DecimalFormat;
import java.util.Map;

public class YieldCalculator {

    private static final String YIELD_FORMAT = "#,##0.0%";
    private final double yield;

    public YieldCalculator(Map<Rankings, Integer> result, int purchaseAmount) {
        this.yield = calculateYield(result, purchaseAmount);
    }

    private double calculateYield(Map<Rankings, Integer> result, int purchaseAmount) {
        return getTotalPrizeMoney(result) / purchaseAmount;
    }

    private double getTotalPrizeMoney(Map<Rankings, Integer> result) {
        int sum = 0;
        for (Rankings rankings : result.keySet()) {
            sum += rankings.getPrizeMoney(result.get(rankings));
        }
        return sum;
    }

    public String getYield() {
        DecimalFormat df = new DecimalFormat(YIELD_FORMAT);
        return df.format(yield);
    }
}
