package lotto.domain;

import java.util.Collections;
import java.util.List;

public class LottoNumbersValidator {
    public static void Validator(List<Integer> numbers) {
        // 사이즈 검증
        validateSize(numbers);
        // 중복 검증
        validateDuplicatedNumber(numbers);
        // 범위 검증
        validateRange(numbers);
    }

    private static void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(LottoNumbersValidateStatus.LOTTO_NUMBERS_SIZE_ERROR.get());
        }
    }

    private static void validateDuplicatedNumber(List<Integer> numbers) {
        boolean duplicate = numbers.stream().distinct().count() != numbers.size();

        if (duplicate) {
            throw new IllegalStateException(LottoNumbersValidateStatus.LOTTO_NUMBERS_DUPLICATE_ERROR.get());
        }
    }

    private static void validateRange(List<Integer> numbers) {
        maxValidate(numbers);
        minValidate(numbers);
    }

    private static void maxValidate(List<Integer> numbers) {
        if (Collections.max(numbers) > 45) {
            throw new NumberFormatException(LottoNumbersValidateStatus.LOTTO_NUMBERS_RANGE_ERROR.get());
        }
    }

    private static void minValidate(List<Integer> numbers) {
        if (Collections.min(numbers) < 1) {
            throw new NumberFormatException(LottoNumbersValidateStatus.LOTTO_NUMBERS_RANGE_ERROR.get());
        }
    }
}
