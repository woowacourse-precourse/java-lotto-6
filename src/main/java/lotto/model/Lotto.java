package lotto.model;

import java.util.List;
import java.util.stream.Stream;

public class Lotto {

    private static final int NUMBERS_COUNT = 6;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;

    private final List<Integer> numbers;

    public Lotto(final List<Integer> numbers) {
        validateCount(numbers);
        validateInRange(numbers);
        validateNotDuplicated(numbers);
        this.numbers = numbers;
    }

    protected void validateCount(final List<Integer> numbers) {
        if (numbers.size() != NUMBERS_COUNT) {
            throw new IllegalArgumentException();
        }
    }

    protected void validateInRange(final List<Integer> numbers) {
        boolean outOfRange = numbers.stream().anyMatch(this::isOutOfRange);
        if (outOfRange) {
            throw new IllegalArgumentException();
        }
    }

    protected void validateNotDuplicated(final List<Integer> numbers) {
        boolean hasDuplicates = numbers.stream().distinct().count() != numbers.size();
        if (hasDuplicates) {
            throw new IllegalArgumentException();
        }
    }

    protected boolean isOutOfRange(final int number) {
        return number < MIN_NUMBER || number > MAX_NUMBER;
    }

    public boolean contains(final int number) {
        return numbers.contains(number);
    }

    public Stream<Integer> stream() {
        return numbers.stream();
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
