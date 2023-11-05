package lotto.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static lotto.constant.LottoConfig.*;

public class WinningNumbers {
    private final List<Integer> numbers;

    public WinningNumbers(List<Integer> numbers) {
        validateCounts(numbers);
        validateRange(numbers);
        validateDuplicate(numbers);
        this.numbers = numbers;
    }

    private void validateCounts(List<Integer> numbers) {
        if (numbers.size() != LOTTO_COUNT_NUMBER.getValue()) {
            throw new IllegalArgumentException();
        }
    }

    private void validateRange(List<Integer> numbers) {
        if (numbers.stream()
                .anyMatch(n -> n < LOTTO_START_NUMBER.getValue() || n > LOTTO_END_NUMBER.getValue())) {
            throw new IllegalArgumentException();
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException();
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
