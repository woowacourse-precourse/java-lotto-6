package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import lotto.utils.ErrorMessage;

public class Lotto {

    private static final int CORRECT_NUMBERS_SIZE = 6;
    private static final String ERROR_MESSAGE_PREFIX = "[ERROR] ";

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = ascendingSortNumbers(numbers);
    }

    private void validate(List<Integer> numbers) {
        if (isNumbersSizeNotSix(numbers)) {
            throw new IllegalArgumentException(
                    ERROR_MESSAGE_PREFIX + ErrorMessage.NUMBERS_SIZE_NOT_SIX_EXCEPTION_MESSAGE.getMessage());
        }
        if (isNumbersDuplicate(numbers)) {
            throw new IllegalArgumentException(
                    ERROR_MESSAGE_PREFIX + ErrorMessage.NUMBERS_DUPLICATE_EXCEPTION_MESSAGE.getMessage());
        }
        if (isNumbersWrongRange(numbers)) {
            throw new IllegalArgumentException(
                    ERROR_MESSAGE_PREFIX + ErrorMessage.NUMBERS_WRONG_RANGE_EXCEPTION_MESSAGE.getMessage());
        }
    }

    private boolean isNumbersSizeNotSix(List<Integer> numbers) {
        return numbers.size() != CORRECT_NUMBERS_SIZE;
    }

    private boolean isNumbersDuplicate(List<Integer> numbers) {
        long numbersDistinctSize = numbers.stream()
                .distinct().count();
        return numbersDistinctSize != CORRECT_NUMBERS_SIZE;
    }

    private boolean isNumbersWrongRange(List<Integer> numbers) {
        long correntNumbersRangeCount = numbers.stream()
                .filter(number -> number >= 1 && number <= 45)
                .count();
        return correntNumbersRangeCount != CORRECT_NUMBERS_SIZE;
    }

    private List<Integer> ascendingSortNumbers(List<Integer> numbers) {
        return numbers.stream().sorted().collect(Collectors.toList());
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }
}
