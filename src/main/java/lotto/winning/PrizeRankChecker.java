package lotto.winning;

import java.util.List;

public class PrizeRankChecker {
    private int calculateNumberMatch(List<Integer> lotto, List<Integer> numbers) {
        return (int) lotto.stream()
                .filter(numbers::contains)
                .count();
    }
}
