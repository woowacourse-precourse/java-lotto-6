package lotto.domain;

public class LottoReturnRate {

    private double purchaseAmount;
    private double returnRate;

    public LottoReturnRate(int purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
        returnRate = 0.0;
    }

    public void calculateReturnRate(long totalPrizeMoney) {
        if (totalPrizeMoney > 0) {
            returnRate = totalPrizeMoney / purchaseAmount * 100;
        }
    }

    public double getReturnRate() {
        return returnRate;
    }
}
