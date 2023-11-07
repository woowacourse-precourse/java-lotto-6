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
        winningResult.put(FIRST, countFirst(winningCounts));
        winningResult.put(SECOND, countSecond(winningCounts));
        winningResult.put(THIRD, countThird(winningCounts));
        winningResult.put(FOURTH, countFourth(winningCounts));
        winningResult.put(FIFTH, countFifth(winningCounts));
        return winningResult;
    }

    public static double calculateProfitRate(List<WinningCount> winningCounts, int purchaseAmount) {
        return calculateProfit(winningCounts) * 100.0 / purchaseAmount;
    }

    private static int calculateProfit(List<WinningCount> winningCounts) {
        return countFirst(winningCounts) * FIRST.getPrize()
                + countSecond(winningCounts) * SECOND.getPrize()
                + countThird(winningCounts) * THIRD.getPrize()
                + countFourth(winningCounts) * FOURTH.getPrize()
                + countFifth(winningCounts) * FIFTH.getPrize();
    }


    private static int countFirst(List<WinningCount> winningCounts) {
        return (int) winningCounts.stream()
                .filter(winningCount -> winningCount.getWinningCount() == FIRST.getCount())
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

    private static int countFourth(List<WinningCount> winningCounts) {
        return (int) winningCounts.stream()
                .filter(winningCount -> winningCount.getWinningCount() == FOURTH.getCount())
                .count();
    }

    private static int countFifth(List<WinningCount> winningCounts) {
        return (int) winningCounts.stream()
                .filter(winningCount -> winningCount.getWinningCount() == FIFTH.getCount())
                .count();
    }
}
