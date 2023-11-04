package lotto.utils;

import static lotto.constant.DomainConstant.LOTTO_SIZE;
import static lotto.constant.DomainConstant.MAX_LOTTO_NUMBER;
import static lotto.constant.DomainConstant.MIN_LOTTO_NUMBER;
import static lotto.constant.ErrorMessage.DUPLICATE_LOTTO_NUMBERS;
import static lotto.constant.ErrorMessage.INVALID_LOTTO_NUMBER_RANGE;
import static lotto.constant.ErrorMessage.INVALID_NUMBER_OF_LOTTO_NUMBERS;

import java.util.HashSet;
import java.util.List;

public class LottoValidateUtils {
    public static void validateLottoNumbers(final List<Integer> numbers) {
        validateSize(numbers);
        validateNumberRange(numbers);
        validateNoDuplicates(numbers);
    }
    public static void validateNumberRange(final int number) {
        if (!isValidLottoNumber(number)) {
            throw new IllegalArgumentException(INVALID_LOTTO_NUMBER_RANGE.getMessage());
        }
    }
    private static void validateSize(final List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE.getValue()) {
            throw new IllegalArgumentException(INVALID_NUMBER_OF_LOTTO_NUMBERS.getMessage());
        }
    }

    private static void validateNumberRange(final List<Integer> numbers) {
        if (numbers.stream().anyMatch(number -> !isValidLottoNumber(number))) {
            throw new IllegalArgumentException(INVALID_LOTTO_NUMBER_RANGE.getMessage());
        }
    }

    private static void validateNoDuplicates(List<Integer> numbers) {
        if (new HashSet<>(numbers).size() != LOTTO_SIZE.getValue()) {
            throw new IllegalArgumentException(DUPLICATE_LOTTO_NUMBERS.getMessage());
        }
    }

    private static boolean isValidLottoNumber(int number) {
        return number >= MIN_LOTTO_NUMBER.getValue() && number <= MAX_LOTTO_NUMBER.getValue();
    }
}
