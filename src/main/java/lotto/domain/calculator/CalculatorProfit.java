package lotto.domain.calculator;

import lotto.domain.Rank;

import java.util.List;

public class CalculatorProfit {
    public int calculateTotalPrize(List<Rank> ranks) {
        int totalPrize = 0;
        for (Rank rank : ranks) {
            totalPrize += rank.getPrize() * countRanks(ranks, rank);
        }
        return totalPrize;
    }

    private int countRanks(List<Rank> ranks, Rank targetRank) {
        int count = 0;
        for (Rank rank : ranks) {
            if (rank == targetRank) {
                count++;
            }
        }
        return count;
    }

    public double calculateTotalProfitRate(int totalPrize, long purchaseAmount) {
        return ((double) totalPrize / purchaseAmount) * 100.0;
    }
}