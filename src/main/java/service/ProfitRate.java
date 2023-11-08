package service;

import domain.Amount;
import domain.Result;

public class ProfitRate {
    private ProfitRate() {
    }

    public static double profitRate(Amount amount, Result result) {
        int reward = result.getReward();
        return amount.calculateProfitRate(reward);
    }
}
