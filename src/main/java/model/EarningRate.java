package model;

import java.util.Arrays;

public class EarningRate {
    private final double earningRate;

    public EarningRate(Money money, PrizeResult prizeResult) {
        this.earningRate = (double) getWonMoney(prizeResult) / money.getMoney() * 100;
    }

    private long getWonMoney(PrizeResult prizeResult) {
        return Arrays.stream(Prize.values())
                .mapToLong(prize -> prizeResult.getPrizeCount(prize) * prize.getMoney())
                .sum();
    }


    public double getEarningRate() {
        return earningRate;
    }
}
