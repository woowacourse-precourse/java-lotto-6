package lotto.domain.result;

public class TotalRate {
    private static final double RATE_MULTIPLIER = 100.0;
    private Double rate;

    public void calculateRate(Integer lottosPrice, Integer winningSum) {
        double totalRate = (winningSum.doubleValue() / lottosPrice) * RATE_MULTIPLIER;
        this.rate = Math.round(totalRate * RATE_MULTIPLIER) / RATE_MULTIPLIER;
    }

    public Double getRate() {
        return rate;
    }
}

