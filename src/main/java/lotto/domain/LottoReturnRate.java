package lotto.domain;

public class LottoReturnRate {

    private static final double DEFAULT_RETURN_COUNT = 0.0;
    private static final int MINIMUM_TOTAL_MONEY = 0;
    private static final int ONE_HUNDRED_PERCENTAGE_MAKER = 100;

    private final double purchaseAmount;
    private double returnRate;

    public LottoReturnRate(int purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
        returnRate = DEFAULT_RETURN_COUNT;
    }

    public void calculateReturnRate(long totalPrizeMoney) {
        if (totalPrizeMoney > MINIMUM_TOTAL_MONEY) {
            returnRate = totalPrizeMoney / purchaseAmount * ONE_HUNDRED_PERCENTAGE_MAKER;
        }
    }

    public double getReturnRate() {
        return returnRate;
    }
}
