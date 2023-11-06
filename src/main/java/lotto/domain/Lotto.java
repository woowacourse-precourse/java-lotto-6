package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.utils.Constants;
import lotto.utils.ErrorMessage;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateLotto(numbers);
        this.numbers = numbers;
    }

    private void validateLotto(List<Integer> numbers) {
        validateLottoCount(numbers);
        validateLottoRange(numbers);
        validateLottoUniqueNumbers(numbers);
    }

    private void validateLottoCount(List<Integer> numbers) {
        if (numbers.size() != Constants.LOTTO_NUMBER_COUNTS) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_COUNT_INVALID_ERROR.getMessage());
        }
    }

    private void validateLottoRange(List<Integer> numbers) {
        for (int number : numbers) {
            validateRange(number);
        }
    }

    private void validateRange(int number) {
        if (!isWithinRange(number)) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_RANGE_INVALID_ERROR.getMessage());
        }
    }

    private boolean isWithinRange(int number) {
        return number >= Constants.LOTTO_MIN_NUMBER && number <= Constants.LOTTO_MAX_NUMBER;
    }

    private void validateLottoUniqueNumbers(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        validateDuplication(uniqueNumbers, numbers);
    }

    private void validateDuplication(Set<Integer> uniqueNumbers, List<Integer> numbers) {
        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_DUPLICATION_ERROR.getMessage());
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
