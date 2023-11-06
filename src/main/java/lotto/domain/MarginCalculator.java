package lotto.domain;

import java.util.Map;

public class MarginCalculator {

    private final double margin;

    public MarginCalculator(Map<Rankings,Integer> result, int purchaseAmount) {
        this.margin = calculateMargin(result, purchaseAmount);
    }

    public double calculateMargin(Map<Rankings,Integer> result, int purchaseAmount) {
        return getTotalPrizeMoney(result) / purchaseAmount * 100;
    }

    public double getTotalPrizeMoney(Map<Rankings,Integer> result) {
        int sum = 0;
        for (Rankings rankings : result.keySet()) {
            sum += rankings.getPrizeMoney(result.get(rankings));
        }
        return sum;
    }

    public String getMargin() {
        return String.format("%.1f", margin);
    }
}
