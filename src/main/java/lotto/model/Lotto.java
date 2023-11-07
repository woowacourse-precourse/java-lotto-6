package lotto.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.constants.Constants;
import lotto.constants.ErrorMessage;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateCount(numbers);
        validateRange(numbers);
        validateDuplication(numbers);
        this.numbers = numbers;
    }

    private void validateCount(List<Integer> numbers) {
        if (numbers.size() != Constants.LOTTO_SIZE.getConstants()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_COUNT.getMessage());
        }
    }

    private void validateRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < Constants.MIN_NUMBER.getConstants() || number > Constants.MAX_NUMBER.getConstants()) {
                throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_NUMBER.getMessage());
            }
        }
    }

    private void validateDuplication(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != Constants.LOTTO_SIZE.getConstants()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_DUPLICATE_NUMBER.getMessage());
        }
    }

    public List<Integer> getLotto() {
        return numbers;
    }
}
