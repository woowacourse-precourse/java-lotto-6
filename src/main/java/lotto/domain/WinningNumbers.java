package lotto.domain;

import java.util.Arrays;
import java.util.List;

public class WinningNumbers {

    private final List<Integer> numbers;
    private final int bonusNumber;

    public WinningNumbers(List<Integer> numbers, int bonusNumber) {
        this.numbers = numbers;
        this.bonusNumber = bonusNumber;
    }

    public Rank determineRank(Lotto lotto) {
        long matchCount = numbers.stream()
                .filter(lotto::contains)
                .count();
        boolean hasBonusNumber = lotto.contains(bonusNumber);
        return Arrays.stream(Rank.values())
                .filter(rank -> rank.matchesCondition(matchCount, hasBonusNumber))
                .findFirst()
                .orElse(Rank.MISS);
    }
}
