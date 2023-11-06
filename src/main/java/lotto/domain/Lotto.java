package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import lotto.utils.Constants;
import lotto.utils.ErrorMessage;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateLotto(numbers);
        this.numbers = numbers;
    }

    public void validateLotto(List<Integer> numbers) {
        validateCount(numbers);
        validateRange(numbers);
        validateUniqueNumbers(numbers);
    }

    private void validateCount(List<Integer> numbers) {
        if (numbers.size() != Constants.LOTTO_NUMBER_COUNTS) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_COUNT_INVALID_ERROR.getMessage());
        }
    }

    private void validateRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (number > Constants.LOTTO_MAX_NUMBER || number < Constants.LOTTO_MIN_NUMBER) {
                throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_RANGE_INVALID_ERROR.getMessage());
            }
        }
    }

    private void validateUniqueNumbers(List<Integer> numbers) {
        List<Integer> check = new ArrayList<>();
        for (int number : numbers) {
            if (check.contains(number)) {
                throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_DUPLICATION_ERROR.getMessage());
            }
            check.add(number);
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
