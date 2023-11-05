package lotto.model;

import java.util.List;

public class Lotto {
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final int LOTTO_NUMBERS_COUNT = 6;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = sorted(numbers);
    }

    private void validate(List<Integer> numbers) {
        validateNumbersSize(numbers);
        validateDuplicatedNumber(numbers);
        validateNumbersRange(numbers);
    }

    private void validateNumbersRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            validateNumberRange(number);
        }
    }

    private void validateNumberRange(Integer number) {
        if (number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException();
        }
    }

    private void validateNumbersSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBERS_COUNT) {
            throw new IllegalArgumentException();
        }
    }

    private void validateDuplicatedNumber(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != LOTTO_NUMBERS_COUNT) {
            throw new IllegalArgumentException();
        }
    }

    private List<Integer> sorted(List<Integer> numbers) {
        return numbers.stream()
                .sorted()
                .toList();
    }
}
