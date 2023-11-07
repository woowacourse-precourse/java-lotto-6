package lotto.domain;

import java.util.List;
import lotto.Rank;
import lotto.exception.ExceptionMessage;

public class Lotto {
    private final List<Integer> numbers;
    private static final int MIN = 1;
    private static final int MAX = 45;
    private static final int SIZE = 6;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateNotDuplicated(numbers);
        validateRange(numbers);
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != SIZE) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_SIZE.getMessage());
        }
    }

    private void validateNotDuplicated(List<Integer> numbers) {
        if (duplicated(numbers)) {
            throw new IllegalArgumentException(ExceptionMessage.DUPLICATED_NUMBERS.getMessage());
        }
    }

    private boolean duplicated(List<Integer> numbers) {
        long distinctSize = numbers.stream().
                distinct().
                count();
        return numbers.size() != distinctSize;
    }

    private void validateRange(List<Integer> numbers) {
        if (outOfRange(numbers)) {
            throw new IllegalArgumentException(ExceptionMessage.NUMBERS_OUT_OF_RANGE.getMessage());
        }
    }

    private boolean outOfRange(List<Integer> numbers) {
        return numbers.stream()
                .anyMatch(this::outOfRange);
    }

    private boolean outOfRange(int number) {
        return number < MIN || number > MAX;
    }

    public Rank rank(Lotto winningLotto, int bonus) {
        int matches = (int) numbers.stream()
                .filter(winningLotto.numbers::contains)
                .count();
        boolean bonusMatched = numbers.contains(bonus);
        return Rank.from(matches, bonusMatched);
    }

    public boolean contains(int number) {
        return numbers.contains(number);
    }
}
