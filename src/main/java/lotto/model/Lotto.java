package lotto.model;

import static lotto.exception.ExceptionMessage.INVALID_DUPLICATE_NUMBER;
import static lotto.exception.ExceptionMessage.INVALID_LENGTH_RANDOM_NUMBER;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private static final int LOTTO_NUMBER_COUNT = 6;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = new ArrayList<>(numbers);
        Collections.sort(this.numbers);
    }

    private void validate(List<Integer> numbers) {
        validateLength(numbers);
        validateDuplicate(numbers);
    }

    private void validateLength(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(
                    String.format(INVALID_LENGTH_RANDOM_NUMBER.getErrorMessage(), LOTTO_NUMBER_COUNT));
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        long uniqueCount = numbers.stream().distinct().count();
        if (uniqueCount != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(INVALID_DUPLICATE_NUMBER.getErrorMessage());
        }
    }

    public List<Integer> getNumbers() {
        return new ArrayList<>(numbers);
    }

    public boolean hasNumber(int bonusNumber) {
        return this.getNumbers().contains(bonusNumber);
    }
}
