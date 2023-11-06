package lotto.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WinningNumbers {
    private final List<Integer> numbers;
    private final int bonusNumber;

    public WinningNumbers(List<Integer> numbers, int bonusNumber) {
        this.numbers = numbers;
        this.bonusNumber = bonusNumber;
    }

    public int countMatchNumbers(Lotto lotto) {
        Set<Integer> winningNumbersSet = new HashSet<>(numbers);
        int matchCount = calculateMatchCount(lotto, winningNumbersSet);
        return adjustMatchCount(matchCount, lotto);
    }

    private int calculateMatchCount(Lotto lotto, Set<Integer> winningNumbersSet) {
        return (int) lotto.getNumbers().stream()
                .filter(winningNumbersSet::contains)
                .count();
    }

    private int adjustMatchCount(int matchCount, Lotto lotto) {
        if (matchCount == numbers.size() && lotto.contains(bonusNumber)) {
            return numbers.size() - 1;
        }
        return matchCount;
    }

    public boolean hasBonusNumber(Lotto lotto) {
        return lotto.contains(bonusNumber);
    }
}
