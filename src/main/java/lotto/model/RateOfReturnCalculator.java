package lotto.model;

public class RateOfReturnCalculator {

    public double calculate(long prizeMoney, int purchaseAmount) {
        return 100 * ((double) prizeMoney / purchaseAmount);
    }
}
