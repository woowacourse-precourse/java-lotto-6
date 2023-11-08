package lotto.domain;

import static lotto.constants.Constants.LOTTO_NUMBER_COUNT;
import static lotto.constants.Constants.MAX_LOTTO_NUMBER;
import static lotto.constants.Constants.MIN_LOTTO_NUMBER;
import static lotto.constants.ErrorMessage.LOTTO_NUMBER_COUNT_ERROR_MESSAGE;
import static lotto.constants.ErrorMessage.LOTTO_NUMBER_DUPLICATE_ERROR_MESSAGE;
import static lotto.constants.ErrorMessage.LOTTO_NUMBER_RANGE_ERROR_MESSAGE;

import java.util.HashSet;
import java.util.List;
import java.util.function.Predicate;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public boolean hasNumber(int number) {
        return numbers.contains(number);
    }

    public int getDuplicatedNumberCount(Lotto lotto) {
        long count = numbers.stream()
                .filter(l -> lotto.getNumbers().stream()
                        .anyMatch(Predicate.isEqual(l))).count();

        return (int) count;
    }

    private void validate(List<Integer> numbers) {
        validateNumberCount(numbers);
        validateNumbersRange(numbers);
        validateNumbersForDuplicates(numbers);
    }

    private void validateNumberCount(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(LOTTO_NUMBER_COUNT_ERROR_MESSAGE);
        }
    }

    private void validateNumbersRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            validateSingleNumberRange(number);
        }
    }

    protected void validateSingleNumberRange(Integer number) {
        if (number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException(LOTTO_NUMBER_RANGE_ERROR_MESSAGE);
        }
    }

    private void validateNumbersForDuplicates(List<Integer> numbers) {
        HashSet<Integer> distinctNumbers = new HashSet<>(numbers);
        if (numbers.size() != distinctNumbers.size()) {
            throw new IllegalArgumentException(LOTTO_NUMBER_DUPLICATE_ERROR_MESSAGE);
        }
    }
}