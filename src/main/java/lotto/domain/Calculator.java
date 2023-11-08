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
        winningResult.put(SECOND, countSecond(winningCounts));
        winningResult.put(THIRD, countThird(winningCounts));
        winningResult.put(FOURTH, countRank(winningCounts, FOURTH));
        winningResult.put(FIFTH, countRank(winningCounts, FIFTH));
        return winningResult;
    }

    public static double calculateProfitRate(Map<Rank, Integer> winningResult, int purchaseAmount) {
        return calculateProfit(winningResult) * 100.0 / purchaseAmount;
    }

    private static int calculateProfit(Map<Rank, Integer> winningResult) {
        return winningResult.get(FIRST) * FIRST.getPrize()
                + winningResult.get(SECOND) * SECOND.getPrize()
                + winningResult.get(THIRD) * THIRD.getPrize()
                + winningResult.get(FOURTH) * FOURTH.getPrize()
                + winningResult.get(FIFTH) * FIFTH.getPrize();
    }


    private static int countRank(List<WinningCount> winningCounts, Rank rank) {
        return (int) winningCounts.stream()
                .filter(winningCount -> winningCount.getWinningCount() == rank.getCount())
                .count();
    }

    private static int countSecond(List<WinningCount> winningCounts) {
        return (int) winningCounts.stream()
                .filter(winningCount -> winningCount.getWinningCount() == SECOND.getCount()
                        && winningCount.hasBonusNumber())
                .count();
    }

    private static int countThird(List<WinningCount> winningCounts) {
        return (int) winningCounts.stream()
                .filter(winningCount -> winningCount.getWinningCount() == THIRD.getCount()
                        && !winningCount.hasBonusNumber())
                .count();
    }
}
