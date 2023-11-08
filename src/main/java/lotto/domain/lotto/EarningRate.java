package lotto.domain.lotto;

public class EarningRate {

    private static final int RATE_UNIT = 100;

    private final double rate;

    public EarningRate(long totalPrize, Price buyPrice) {
        this.rate = calculateRate(totalPrize, buyPrice);
    }

    public double getRate() {
        return rate;
    }

    public double calculateRate(long totalPrize, Price buyPrice) {
        return ((double) totalPrize / buyPrice.getAmount()) * RATE_UNIT;
    }

}
