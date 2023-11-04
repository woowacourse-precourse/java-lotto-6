package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateNumbersSize(numbers);
        validateDuplication(numbers);
        this.numbers = numbers;
    }

    private void validateNumbersSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void validateDuplication(List<Integer> numbers) {
        List<Integer> deduplicatedNumbers = numbers.stream()
                                                .distinct()
                                                .collect(Collectors.toList());
        if (deduplicatedNumbers.size() == numbers.size()) {
            return;
        }
        throw new IllegalArgumentException();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
