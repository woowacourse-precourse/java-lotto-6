package lotto;

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
        validateRange(numbers);
        validateDuplicate(numbers);
    }

    private void validateRange(final List<Integer> numbers) {
        boolean notMatchRange = numbers.stream().anyMatch(number -> number < 1 || number > 45);
        if (notMatchRange) {
            throw new IllegalArgumentException();
        }
    }

    private void validateDuplicate(final List<Integer> numbers) {
        long distinctCount = numbers.stream()
                .distinct()
                .count();
        if (isNotEqual(distinctCount, numbers.size())) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isNotEqual(final long distinctCount, final int lottoNumbersCount) {
        return distinctCount != lottoNumbersCount;
    }
}
