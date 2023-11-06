package lotto.domain;

import java.util.Map;

public class Calculator {
    public static int calculateTotalPrize(Map<Rank, Integer> rankCount) {
        int totalPrize = 0;
        for (Rank rank : Rank.values()) {
            totalPrize += rank.getPrize() * rankCount.getOrDefault(rank, 0);
        }
        return totalPrize;
    }

    public double calculateEarningRate(int totalPrize, Money money) {
        return ((double) totalPrize / money.getMoney()) * 100;
    }
}
