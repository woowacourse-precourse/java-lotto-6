package lotto.validator.domain;

import java.util.List;
import lotto.domain.lotto.LottoCondition;

public class LottoNumbersValidator {

    private static final String OUT_OF_RANGE_LOTTO_NUMBER = "[ERROR] 로또 번호는 1~45 사이의 숫자여야 합니다.";
    private static final String INVALID_LOTTO_LENGTH = "[ERROR] 로또 번호의 길이는 6개여야 합니다.";
    private static final String DUPLICATES_LOTTO_NUMBERS = "[ERROR] 로또 번호는 중복을 허용하지 않습니다.";

    private LottoNumbersValidator() {
    }

    public static void validate(List<Integer> numbers) {
        validateLength(numbers);
        validateDuplicates(numbers);
        validateRange(numbers);
    }

    private static void validateRange(final List<Integer> numbers) {
        if (isOutOfRange(numbers)) {
            throw new IllegalArgumentException(OUT_OF_RANGE_LOTTO_NUMBER);
        }
    }

    private static boolean isOutOfRange(final List<Integer> numbers) {
        return numbers.stream()
                .anyMatch(LottoCondition::isNotInRange);
    }

    private static void validateLength(final List<Integer> numbers) {
        if (LottoCondition.isInvalidLength(numbers.size())) {
            throw new IllegalArgumentException(INVALID_LOTTO_LENGTH);
        }
    }

    private static void validateDuplicates(final List<Integer> numbers) {
        if (isDuplicate(numbers)) {
            throw new IllegalArgumentException(DUPLICATES_LOTTO_NUMBERS);
        }
    }

    private static boolean isDuplicate(final List<Integer> numbers) {
        return numbers.stream()
                .distinct()
                .toList()
                .size() != numbers.size();
    }
}
