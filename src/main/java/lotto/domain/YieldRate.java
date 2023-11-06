package lotto.domain;

public class YieldRate {
    private double yieldRate;

    public YieldRate(int spendMoney, long gainMoney) {
        this.yieldRate = (double) gainMoney / spendMoney;
    }

    public double getYieldRate() {
        return yieldRate * 100;
    }
}
