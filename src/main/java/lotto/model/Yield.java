package lotto.model;

import lotto.util.Constant;

public class Yield {

    private String yield;

    public void calculateYield(long totalPrizeMoney, int purchaseAmount) {
        double result = (totalPrizeMoney * Constant.CONVERT_PERCENT) / (double) purchaseAmount;
        this.yield = String.format("%.1f", result);
    }

    public String getYield() {
        return yield;
    }
}
