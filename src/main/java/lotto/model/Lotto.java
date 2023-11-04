package lotto.model;

import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateSize(numbers);
        validateDistinctNumbers(numbers);
        validateNumbersRange(numbers);
        Collections.sort(numbers);
        this.numbers = numbers;
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void validateDistinctNumbers(List<Integer> numbers) {
        if(numbers.size() != numbers.stream()
                .distinct()
                .count()) {
            throw new IllegalArgumentException();
        }
    }

    private void validateNumbersRange(List<Integer> numbers) {
        if(numbers.stream()
                .anyMatch(number -> number < 1 || number > 45)) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
}
