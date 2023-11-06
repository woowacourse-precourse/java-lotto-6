package lotto.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static lotto.exception.ErrorMessage.*;

public class Lotto {
    private static final int LOTTO_NUMBER_SIZE = 6;
    private static final int LOTTO_MIN_NUMBER = 1;
    private static final int LOTTO_MAX_NUMBER = 45;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers){
        validateNumberSize(numbers);
        validateNumberDuplication(numbers);
        validateNumberRange(numbers);
    }

    private void validateNumberSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException(INVALID_LOTTO_SIZE.getMessage());
        }
    }

    private void validateNumberDuplication(List<Integer> numbers) {
        long distinctNumber = numbers.stream()
                .distinct()
                .count();

        if (distinctNumber < numbers.size()) {
            throw new IllegalArgumentException(LOTTO_NUMBER_DUPLICATED.getMessage());
        }
    }

    private void validateNumberRange(List<Integer> numbers) {
        if (isWrongRangeNumber(numbers)) {
            throw new IllegalArgumentException(INVALID_LOTTO_NUMBER_RANGE.getMessage());
        }
    }

    private boolean isWrongRangeNumber(List<Integer> numbers) {
        return numbers.stream()
                .anyMatch(number -> number < LOTTO_MIN_NUMBER
                        || number > LOTTO_MAX_NUMBER);
    }

    public String getSortedNumbers() {
        return numbers.stream()
                .sorted()
                .map(number -> number.toString())
                .toList()
                .toString();
    }

    public boolean isContainNumber(int number){
        return numbers.contains(number);
    }
}
