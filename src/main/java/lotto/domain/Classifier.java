package lotto.domain;

import static lotto.constants.Rank.FIFTH;
import static lotto.constants.Rank.FIRST;
import static lotto.constants.Rank.FOURTH;
import static lotto.constants.Rank.SECOND;
import static lotto.constants.Rank.THIRD;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Classifier {
    List<WinningNumbersCount> winningNumbersCounts;

    public Map<Integer, Integer> classify(List<WinningNumbersCount> winningNumbersCounts) {
        this.winningNumbersCounts = winningNumbersCounts;
        Map<Integer, Integer> winningResult = new HashMap<>();
        winningResult.put(1, countFirst());
        winningResult.put(2, countSecond());
        winningResult.put(3, countThird());
        winningResult.put(4, countFourth());
        winningResult.put(5, countFifth());
        return winningResult;
    }

    private int countFirst() {
        return (int) winningNumbersCounts.stream()
                .filter(winningNumbersCount -> winningNumbersCount.getCount() == FIRST.getCount())
                .count();
    }

    private int countSecond() {
        return (int) winningNumbersCounts.stream()
                .filter(winningNumbersCount -> winningNumbersCount.getCount() == SECOND.getCount()
                        && winningNumbersCount.hasBonusNumber())
                .count();
    }

    private int countThird() {
        return (int) winningNumbersCounts.stream()
                .filter(winningNumbersCount -> winningNumbersCount.getCount() == THIRD.getCount()
                        && !winningNumbersCount.hasBonusNumber())
                .count();
    }

    private int countFourth() {
        return (int) winningNumbersCounts.stream()
                .filter(winningNumbersCount -> winningNumbersCount.getCount() == FOURTH.getCount())
                .count();
    }

    private int countFifth() {
        return (int) winningNumbersCounts.stream()
                .filter(winningNumbersCount -> winningNumbersCount.getCount() == FIFTH.getCount())
                .count();
    }
}
