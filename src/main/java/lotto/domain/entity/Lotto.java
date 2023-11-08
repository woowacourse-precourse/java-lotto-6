package lotto.domain.entity;

import lotto.exception.ExceptionCode;

import java.util.List;

public class Lotto {
    public static final int START = 1;
    public static final int END = 45;
    public static final int COUNT = 6;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplication(numbers);
        validateRange(numbers);
        this.numbers = numbers;
    }

    private void validateSize(final List<Integer> numbers) {
        if (numbers.size() != Lotto.COUNT) {
            throw new IllegalArgumentException(
                    ExceptionCode.LOTTO_INVALID_SIZE.getDescription()
            );
        }
    }

    private void validateRange(final List<Integer> numbers) {
        if (numbers.stream()
                .anyMatch(n -> START > n || END < n)
        ) {
            throw new IllegalArgumentException(
                    ExceptionCode.LOTTO_INVALID_RANGE.getDescription()
            );
        }
    }

    private void validateDuplication(final List<Integer> numbers) {
        if (numbers.size() != getCountWithNoDuplication(numbers)) {
            throw new IllegalArgumentException(
                    ExceptionCode.LOTTO_DUPLICATION.getDescription()
            );
        }
    }

    private long getCountWithNoDuplication(final List<Integer> numbers) {
        return numbers.stream()
                .distinct()
                .count();
    }


    public int calculateCountOfNumberEqualToWinningNumber(final Lotto target) {
        return (int) this.numbers
                .stream()
                .filter(target::contain)
                .count();
    }

    public boolean contain(final int number) {
        return this.numbers.contains(number);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
