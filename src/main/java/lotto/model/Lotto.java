package lotto.model;

import java.util.List;
import java.util.stream.Collectors;

import static lotto.utils.ErrorMessage.*;

public class Lotto {
    private static final Integer VALID_LENGTH = 6;
    private static final Integer MINIMUM_NUMBER = 1;
    private static final Integer MAXIMUM_NUMBER = 45;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        hasValidLength(numbers);
        hasUniqueElement(numbers);
        hasWithinRangeElement(numbers);
    }

    private void hasValidLength(List<Integer> numbers) {
        if (numbers.size() != VALID_LENGTH) {
            throw new IllegalArgumentException(WINNING_NUMBERS_OUT_OF_RANGE_IN_LENGTH.getDescription());
        }
    }

    private void hasUniqueElement(List<Integer> numbers) {
        long uniqueNumberCount = numbers.stream().distinct().count();
        if (uniqueNumberCount != VALID_LENGTH) {
            throw new IllegalArgumentException(WINNING_NUMBERS_NOT_UNIQUE_NUMBER.getDescription());
        }
    }

    private void hasWithinRangeElement(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < MINIMUM_NUMBER || number > MAXIMUM_NUMBER) {
                throw new IllegalArgumentException(WINNING_NUMBERS_OUT_OF_RANGE_NUMBER.getDescription());
            }
        }
    }

    public Boolean contains(Integer number) {
        return numbers.contains(number);
    }

    public Integer compare(List<Integer> numbers) {
        return (int) numbers.stream()
                .filter(this.numbers::contains)
                .count();
    }

    @Override
    public String toString() {
        return "[" + numbers.stream()
                .sorted()
                .map(Object::toString)
                .collect(Collectors.joining(", ")) + "]";
    }
}
