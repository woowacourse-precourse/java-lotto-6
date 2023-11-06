package lotto;

import java.util.List;

import static lotto.LottoConstants.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE.getValue()) {
            throw new IllegalArgumentException();
        }
        if (numbers.stream().distinct().count() != LOTTO_SIZE.getValue()) {
            throw new IllegalArgumentException();
        }
        if (numbers.stream().anyMatch(n -> n < MIN_LOTTO_NUMBER.getValue() || n > MAX_LOTTO_NUMBER.getValue())) {
            throw new IllegalArgumentException();
        }
    }

    public int countMatchingNumbers(List<Integer> winningNumbers) {
        return (int) winningNumbers.stream()
                .filter(numbers::contains)
                .count();
    }

    public boolean hasBonusNumber(int bonusNumber) {
        return numbers.contains(bonusNumber);
    }
}
