package lotto.model;

public class Yield {

    private String yield;

    public void calculateYield(int totalPrizeMoney, int purchaseAmount) {
        double result = totalPrizeMoney / (double) purchaseAmount * 100;
        this.yield = String.format("%.1f", result);
    }

    public String getYield() {
        return yield;
    }
}
