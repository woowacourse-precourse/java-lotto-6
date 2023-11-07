package lotto.domain;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.util.constants.ValidateConstants;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        lottoValidate(numbers);
        validate(numbers);
        this.numbers = numbers;
        sortNumbers();
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }
    private void lottoValidate(List<Integer> numbers) {
        validateDuplication(numbers);
        validateRange(numbers);
    }

    private void validateDuplication(List<Integer> numbers) {
        Set<Integer> numbersSet = new HashSet<>(numbers);
        if (numbers.size() != numbersSet.size()) {
            throw new IllegalArgumentException(ValidateConstants.WINNER_NUMBER_DUPLICATION_ERROR.getConstants());
        }
    }

    private void validateRange(List<Integer> numbers) {
        int min = ValidateConstants.LOTTO_MIN_NUMBER.getNumberConstants();
        int max = ValidateConstants.LOTTO_MAX_NUMBER.getNumberConstants();

        boolean isInvalidRange = numbers.stream()
                .anyMatch(number -> number < min || number > max);
        if (isInvalidRange) {
            throw new IllegalArgumentException(ValidateConstants.WINNER_NUMBER_RANGE_ERROR.getConstants());
        }
    }

    private void sortNumbers() {
        Collections.sort(numbers);
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }
}
