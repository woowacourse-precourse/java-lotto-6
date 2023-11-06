package lotto.validation;

import static lotto.constant.ErrorMessage.DUPLICATION_EXCEPTION;
import static lotto.constant.ErrorMessage.LOTTO_NUMBER_SIZE_EXCEPTION;
import static lotto.constant.ErrorMessage.NULL_EXCEPTION;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoValidation {
    private final int SIZE = 6;

    public void validateLottoNumber(List<Integer> numbers) {
        validateNull(numbers);
        validateSize(numbers);
        validateDuplication(numbers);
    }

    private void validateNull(List<Integer> numbers) {
        if (numbers == null) {
            throw new IllegalArgumentException(NULL_EXCEPTION.getMessage());
        }
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != SIZE) {
            throw new IllegalArgumentException(LOTTO_NUMBER_SIZE_EXCEPTION.getMessage());
        }
    }

    private void validateDuplication(List<Integer> numbers) {
        Set<Integer> distinctNumbers = new HashSet<>(numbers);
        if (distinctNumbers.size() != SIZE) {
            throw new IllegalArgumentException(DUPLICATION_EXCEPTION.getMessage());
        }
    }
}