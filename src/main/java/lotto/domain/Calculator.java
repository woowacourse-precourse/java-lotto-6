package lotto.domain;

import static lotto.constants.Rank.FIFTH;
import static lotto.constants.Rank.FIRST;
import static lotto.constants.Rank.FOURTH;
import static lotto.constants.Rank.SECOND;
import static lotto.constants.Rank.THIRD;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Calculator {
    private static List<WinningCount> winningCounts;

    public static Map<Integer, Integer> classify(List<WinningCount> winningCounts) {
        Calculator.winningCounts = winningCounts;
        Map<Integer, Integer> winningResult = new HashMap<>();
        winningResult.put(1, countFirst());
        winningResult.put(2, countSecond());
        winningResult.put(3, countThird());
        winningResult.put(4, countFourth());
        winningResult.put(5, countFifth());
        return winningResult;
    }

    public static double calculateProfitRate(int purchaseAmount) {
        return calculateProfit() * 100.0 / purchaseAmount;
    }

    private static int calculateProfit() {
        return countFirst() * FIRST.getPrize()
                + countSecond() * SECOND.getPrize()
                + countThird() * THIRD.getPrize()
                + countFourth() * FOURTH.getPrize()
                + countFifth() * FIFTH.getPrize();
    }


    private static int countFirst() {
        return (int) winningCounts.stream()
                .filter(winningCount -> winningCount.getWinningCount() == FIRST.getCount())
                .count();
    }

    private static int countSecond() {
        return (int) winningCounts.stream()
                .filter(winningCount -> winningCount.getWinningCount() == SECOND.getCount()
                        && winningCount.hasBonusNumber())
                .count();
    }

    private static int countThird() {
        return (int) winningCounts.stream()
                .filter(winningCount -> winningCount.getWinningCount() == THIRD.getCount()
                        && !winningCount.hasBonusNumber())
                .count();
    }

    private static int countFourth() {
        return (int) winningCounts.stream()
                .filter(winningCount -> winningCount.getWinningCount() == FOURTH.getCount())
                .count();
    }

    private static int countFifth() {
        return (int) winningCounts.stream()
                .filter(winningCount -> winningCount.getWinningCount() == FIFTH.getCount())
                .count();
    }
}
