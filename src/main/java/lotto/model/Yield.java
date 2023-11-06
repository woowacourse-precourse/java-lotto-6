package lotto.model;

public class Yield {

    private String yield;

    public void calculateYield(int totalPrizeMoney, int purchaseAmount) {
        double result = (totalPrizeMoney * 100) / (double) purchaseAmount;
        this.yield = String.format("%.1f", result);
    }

    public String getYield() {
        return yield;
    }
}
