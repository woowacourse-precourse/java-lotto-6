package lotto;

import java.util.List;

public class WinningNumbers {
    private final List<Integer> numbers;
    private final int bonus;

    public WinningNumbers(List<Integer> numbers, int bonus) {
        this.numbers = numbers;
        this.bonus = bonus;
    }

    public int countMatchingNumbers(Lotto lotto) {
        List<Integer> lottoNumbers = lotto.getNumbers();
        return (int) lottoNumbers.stream()
                .filter(numbers::contains)
                .count();
    }

    public boolean isBonusMatching(Lotto lotto) {
        return lotto.getNumbers().contains(bonus);
    }
}
