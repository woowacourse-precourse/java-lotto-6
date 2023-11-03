package lotto.domain;

import java.util.List;

public class Lotto {

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final int LOTTO_SIZE = 6;

    private final List<Integer> numbers;

    public Lotto(final List<Integer> numbers) {
        validate(numbers);
        validateRange(numbers);
        this.numbers = numbers;
    }

    private void validate(final List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException();
        }
    }

    private void validateRange(final List<Integer> numbers) {
        if (!isAllValidRange(numbers)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isAllValidRange(final List<Integer> numbers) {
        return numbers.stream()
                .allMatch(this::isValidRange);
    }

    private boolean isValidRange(final Integer number) {
        return MIN_NUMBER <= number && number <= MAX_NUMBER;
    }
}
