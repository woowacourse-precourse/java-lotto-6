package lotto.domain;

public class ProfitRateCalculator {

    public double calculate(int purchaseAmount, long reward) {
        double profitRate = (double) reward / purchaseAmount * 100;
        return Math.round(profitRate * 10) / 10.0;
    }
}
