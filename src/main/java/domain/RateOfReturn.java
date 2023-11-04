package domain;

import static constant.ConstantNumber.PERCENTAGE_MULTIPLIER;

public class RateOfReturn {
    private final double rate;

    public RateOfReturn(long totalIncome, long money) {
        this.rate = calculateRateOfReturn(totalIncome, money);
    }

    public double getRate() {
        return rate;
    }

    private static double calculateRateOfReturn(long totalIncome, long money) {
        return (double) totalIncome / money * PERCENTAGE_MULTIPLIER.getNumber();
    }
}
