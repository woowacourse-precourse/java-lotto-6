package lotto.domain;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public LottoMatchResult compare(List<Integer> winningNumbers, int bonusNumber) {
        return new LottoMatchResult(
                getMatchCount(winningNumbers),
                isMatchBonus(bonusNumber)
        );
    }

    private int getMatchCount(List<Integer> winningNumbers) {
        return (int) winningNumbers.stream()
                .filter(numbers::contains)
                .count();
    }

    private boolean isMatchBonus(int bonusNumber) {
        return numbers.contains(bonusNumber);
    }
}
