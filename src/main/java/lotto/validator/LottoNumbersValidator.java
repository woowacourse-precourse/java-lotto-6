package lotto.validator;

import java.util.List;

import lotto.domain.LottoNumbersRule;

public final class LottoNumbersValidator {

    private static final String LENGTH_ERROR_MESSAGE = "[ERROR] 로또 번호는 6개여야 합니다.";
    private static final String DUPLICATION_ERROR_MESSAGE = "[ERROR] 로또 번호에 중복된 숫자가 존재할 수 없습니다.";
    private static final String RANGE_ERROR_MESSAGE = "[ERROR] 로또 번호는 1 ~ 45 숫자만 가능합니다.";

    private LottoNumbersValidator() {
    }

    public static void validate(final List<Integer> numbers) {
        validateNumbersSize(numbers);
        validateDuplicationInNumbers(numbers);
        validateNumberRange(numbers);
    }

    private static void validateNumbersSize(final List<Integer> numbers) {
        if (LottoNumbersRule.isLottoNumbersSizeMismatched(numbers)) {
            throw new IllegalArgumentException(LENGTH_ERROR_MESSAGE);
        }
    }

    private static void validateDuplicationInNumbers(final List<Integer> numbers) {
        if (hasDuplication(numbers)) {
            throw new IllegalArgumentException(DUPLICATION_ERROR_MESSAGE);
        }
    }

    private static boolean hasDuplication(final List<Integer> numbers) {
        return LottoNumbersRule.isLottoNumbersSizeMismatched(
                numbers.stream()
                        .distinct()
                        .toList()
        );
    }

    private static void validateNumberRange(final List<Integer> numbers) {
        if (numbers.stream()
                .anyMatch(LottoNumbersRule::hasOutOfRangeNumber)
        ) {
            throw new IllegalArgumentException(RANGE_ERROR_MESSAGE);
        }
    }

}
