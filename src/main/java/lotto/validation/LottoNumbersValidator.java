package lotto.validation;

import java.util.List;

public class LottoNumbersValidator {
    private static final int RANGE_START = 1;
    private static final int RANGE_END = 45;

    public static void validate(List<Integer> numbers) {
        validateNumbersSize(numbers);
        validateNumbersRange(numbers);
        validateDuplication(numbers);
    }

    private static void validateNumbersSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(LottoException.SIZE_ERROR_MESSAGE.getMessage());
        }
    }

    private static void validateNumbersRange(List<Integer> numbers) {
        if (hasOutOfRangeNumber(numbers)) {
            throw new IllegalArgumentException(LottoException.OUT_RANGE_ERROR_MESSAGE.getMessage());
        }
    }

    private static boolean hasOutOfRangeNumber(List<Integer> numbers) {
        return numbers.stream()
                .anyMatch(number -> number < RANGE_START || number > RANGE_END);
    }

    private static void validateDuplication(List<Integer> numbers) {
        if (isDuplication(numbers)) {
            throw new IllegalArgumentException(LottoException.DUPLICATION_ERROR_MESSAGE.getMessage());
        }
    }

    private static boolean isDuplication(List<Integer> numbers) {
        return numbers.stream()
                .distinct()
                .count() < numbers.size();
    }
}
