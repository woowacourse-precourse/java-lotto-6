package lotto.model;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import lotto.exceptionMessages.ExceptionMessages;

public class Lotto {
    private static final int LOTTO_SIZE = 6;
    private static final int MIN_RANGE = 1;
    private static final int MAX_RANGE = 45;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(ExceptionMessages.EXCEPTION_NUMBER_SIZE.getMessage());
        }
        if (isInvalidRange(numbers)) {
            throw new IllegalArgumentException(ExceptionMessages.EXCEPTION_NUMBER_RANGE.getMessage());
        }
        if (isDuplicate(numbers)) {
            throw new IllegalArgumentException(ExceptionMessages.EXCEPTION_NUMBER_DUPLICATION.getMessage());
        }
    }

    private boolean isInvalidRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < MIN_RANGE || number > MAX_RANGE) {
                return true;
            }
        }
        return false;
    }

    private boolean isDuplicate(List<Integer> numbers) {
        HashSet<Integer> unique = new HashSet<>(numbers);
        return unique.size() != numbers.size();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
