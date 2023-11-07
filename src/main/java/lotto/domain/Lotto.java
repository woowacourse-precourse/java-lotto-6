package lotto.domain;

import lotto.exception.ExceptionMessage;

import java.util.Collections;
import java.util.List;

public class Lotto {
    private static final int LOTTO_NUMBERS_SIZE = 6;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateNumbersCount(numbers);
        validateDuplicateNumbers(numbers);
        this.numbers = numbers;
    }

    private void validateNumbersCount(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBERS_SIZE) {
            ExceptionMessage.LOTTO_WRONG_NUMBERS_COUNT.throwIllegalArgumentException();
        }
    }

    private void validateDuplicateNumbers(List<Integer> numbers) {
        long distinctCount = numbers.stream()
                .distinct()
                .count();

        if (distinctCount != numbers.size()) {
            ExceptionMessage.LOTTO_DUPLICATE_NUMBERS.throwIllegalArgumentException();
        }
    }

    public int countMatchingNumbers(List<Integer> winningNumbers) {
        return Math.toIntExact(numbers.stream()
                .filter(winningNumbers::contains)
                .count());
    }

    public boolean containsNumber(int number) {
        return numbers.contains(number);
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }
}
