package lotto.domain;

import static lotto.constants.Rank.FIFTH;
import static lotto.constants.Rank.FIRST;
import static lotto.constants.Rank.FOURTH;
import static lotto.constants.Rank.SECOND;
import static lotto.constants.Rank.THIRD;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.constants.Rank;

public class Calculator {

    public static Map<Rank, Integer> classify(List<WinningCount> winningCounts) {
        Map<Rank, Integer> winningResult = new HashMap<>();
        winningResult.put(FIRST, countRank(winningCounts, FIRST));
        winningResult.put(SECOND, countRank(winningCounts, SECOND));
        winningResult.put(THIRD, countRank(winningCounts, THIRD));
        winningResult.put(FOURTH, countRank(winningCounts, FOURTH));
        winningResult.put(FIFTH, countRank(winningCounts, FIFTH));
        return winningResult;
    }

    public static double calculateProfitRate(List<WinningCount> winningCounts, int purchaseAmount) {
        return calculateProfit(winningCounts) * 100.0 / purchaseAmount;
    }

    private static int calculateProfit(List<WinningCount> winningCounts) {
        return countRank(winningCounts, FIRST) * FIRST.getPrize()
                + countRank(winningCounts, SECOND) * SECOND.getPrize()
                + countRank(winningCounts, THIRD) * THIRD.getPrize()
                + countRank(winningCounts, FOURTH) * FOURTH.getPrize()
                + countRank(winningCounts, FIFTH) * FIFTH.getPrize();
    }


    private static int countRank(List<WinningCount> winningCounts, Rank rank) {
        return (int) winningCounts.stream()
                .filter(winningCount -> winningCount.getWinningCount() == rank.getCount())
                .count();
    }
}
