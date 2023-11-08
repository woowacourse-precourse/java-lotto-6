package lotto.domain;

public class ProfitRate {

    private static final int PERCENTAGE = 100;

    public double calculate(int purchaseAmount, long reward) {
        return ((double) reward / purchaseAmount) * PERCENTAGE;
    }
}