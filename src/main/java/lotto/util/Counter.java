package lotto.util;

import java.util.List;
import lotto.domain.Rank;
import lotto.domain.Result;

public class Counter {
    private static final int FIFTH_PRIZE_CONDITION = 3;
    private static final int FOURTH_PRIZE_CONDITION = 4;
    private static final int THIRD_PRIZE_CONDITION = 5;
    private static final int FIRST_PRIZE_CONDITION = 6;

    public static Rank countRank(List<Result> results) {
        int fifth = count(results, FIFTH_PRIZE_CONDITION);
        int fourth = count(results, FOURTH_PRIZE_CONDITION);
        int third = count(results, THIRD_PRIZE_CONDITION);
        int second = countWithBonus(results);
        int first = count(results, FIRST_PRIZE_CONDITION);
        return new Rank(fifth, fourth, third, second, first);
    }

    private static int count(List<Result> results, int matchNumbers) {
        return (int) results.stream()
                .filter(result -> result.matchWinningNumbers() == matchNumbers)
                .count();
    }

    private static int countWithBonus(List<Result> results) {
        return (int) results.stream()
                .filter(result -> result.matchWinningNumbers() == THIRD_PRIZE_CONDITION && result.matchBonusNumber())
                .count();
    }
}
