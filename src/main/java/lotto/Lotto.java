package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplicates(numbers);
        validateInRange(numbers);
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void validateDuplicates(List<Integer> numbers) {
        int distinctSize = (int) numbers.stream()
                .distinct()
                .count();
        if (distinctSize != numbers.size()) {
            throw new IllegalArgumentException();
        }
    }

    private void validateInRange(List<Integer> numbers) {
        numbers.stream()
                .filter(number -> number < 1 || number > 45)
                .findAny()
                .ifPresent((i) -> {
                    throw new IllegalArgumentException();
                });
    }
}
