package lotto.domain;

import static lotto.domain.strategy.RandomLottoStrategy.COUNT_LOTTO_NUMBER;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != COUNT_LOTTO_NUMBER) {
            throw new IllegalArgumentException();
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int countMatches(List<Integer> winningNumber) {
        return (int) numbers.stream().filter(winningNumber::contains).count();
    }

    public boolean isBonusMatched(int bonusNumber) {
        return numbers.contains(bonusNumber);
    }
}
