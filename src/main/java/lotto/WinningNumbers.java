package lotto;

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
        int matchCount = (int) lotto.getNumbers().stream()
                .filter(winningNumbersSet::contains)
                .count();
        if (matchCount == numbers.size() && lotto.contains(bonusNumber)) {
            matchCount = numbers.size() - 1;
        }
        return matchCount;
    }

    public boolean hasBonusNumber(Lotto lotto) {
        return lotto.contains(bonusNumber);
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
