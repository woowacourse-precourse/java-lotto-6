package lotto.domain.calculator;

import lotto.domain.Rank;

import java.util.List;

public class CalculatorProfit {
    private int countRanks(List<Rank> ranks, Rank targetRank) {
        int count = 0;
        for (Rank rank : ranks) {
            if (rank == targetRank) {
                count++;
            }
        }
        return count;
    }
}