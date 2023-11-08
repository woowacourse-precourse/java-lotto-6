package lotto.domain;

import lotto.constants.PrizeEnum;

import java.util.HashMap;

public class EarnRate {

    double EarnRate;
    int inputAmount;
    int totalEarning;
    public EarnRate(int inputAmount) {
        this.EarnRate = 1;
        this.inputAmount = inputAmount;
        this.totalEarning = 0;
    }

    public int getTotalEarning(HashMap<String, Integer> checkMatchCount) {
        if (checkMatchCount == null) {
            throw new NullPointerException();
        }
        checkMatchCount.forEach((key, value) -> {
            totalEarning += PrizeEnum.valueOf(key).getAmount() * value;
        });
        return totalEarning;
    }

    public double getEarnRate(){
        if (inputAmount == 0) {
            throw new ArithmeticException("");
        }
        return (double) totalEarning / (double) inputAmount;
    }
}
