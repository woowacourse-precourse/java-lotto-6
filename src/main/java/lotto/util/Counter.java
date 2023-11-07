package lotto.util;

import java.util.List;
import lotto.domain.Rank;
import lotto.domain.Result;

public class Counter {
    public static Rank countRank(List<Result> results) {
        int fifth = count(results, 3);
        int fourth = count(results, 4);
        int third = count(results, 5);
        int second = countWithBonus(results);
        int first = count(results, 6);
        return new Rank(fifth, fourth, third, second, first);
    }

    private static int count(List<Result> results, int matchNumbers) {
        return (int) results.stream()
                .filter(result -> result.matchWinningNumbers() == matchNumbers)
                .count();
    }

    private static int countWithBonus(List<Result> results) {
        return (int) results.stream()
                .filter(result -> result.matchWinningNumbers() == 5 && result.matchBonusNumber())
                .count();
    }
}
