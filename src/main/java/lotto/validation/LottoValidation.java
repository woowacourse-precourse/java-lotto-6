package lotto.validation;

import static lotto.constant.ErrorMessage.DUPLICATION_EXCEPTION;
import static lotto.constant.ErrorMessage.LOTTO_NUMBER_SIZE_EXCEPTION;
import static lotto.constant.ErrorMessage.NULL_EXCEPTION;
import static lotto.constant.LottoConstant.LOTTO_NUMBER_COUNT;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoValidation {
    public static void validateLottoNumber(List<Integer> numbers) {
        validateNull(numbers);
        validateSize(numbers);
        validateDuplication(numbers);
    }

    private static void validateNull(List<Integer> numbers) {
        if (numbers == null) {
            throw new IllegalArgumentException(NULL_EXCEPTION.getMessage());
        }
    }

    private static void validateSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(LOTTO_NUMBER_SIZE_EXCEPTION.getMessage());
        }
    }

    private static void validateDuplication(List<Integer> numbers) {
        Set<Integer> distinctNumbers = new HashSet<>(numbers);
        if (distinctNumbers.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(DUPLICATION_EXCEPTION.getMessage());
        }
    }
}