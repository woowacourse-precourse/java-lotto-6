package lotto;

import static lotto.exception.ExceptionMessage.DUPLICATE_LOTTO_NUMBER_NOT_ALLOWED;
import static lotto.exception.ExceptionMessage.LOTTO_NUMBER_OUT_OF_BOUNDS;
import static lotto.exception.ExceptionMessage.REQUIRED_LOTTO_NUMBERS_COUNT;

import java.util.HashSet;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateLength(numbers);
        validateDuplication(numbers);
        validateNumbersInRange(numbers);
    }

    private void validateLength(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(REQUIRED_LOTTO_NUMBERS_COUNT.getMessage());
        }
    }

    private void validateDuplication(List<Integer> numbers) {
        HashSet<Integer> tempToDuplicateCheck = new HashSet<>();

        for (int i = 0; i < numbers.size(); i++) {
            tempToDuplicateCheck.add(numbers.get(i));
        }

        if (numbers.size() != tempToDuplicateCheck.size()) {
            throw new IllegalArgumentException(DUPLICATE_LOTTO_NUMBER_NOT_ALLOWED.getMessage());
        }
    }

    private void validateNumbersInRange(List<Integer> numbers) {
        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) < 1 || numbers.get(i) > 45) {
                throw new IllegalArgumentException(LOTTO_NUMBER_OUT_OF_BOUNDS.getMessage());
            }
        }
    }
}
