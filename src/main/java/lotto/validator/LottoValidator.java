package lotto.validator;

import java.util.List;

public class LottoValidator {
    private static final int LOTTO_NUMBER_SIZE = 6;
    private static final int LOTTO_MIN_NUMBER = 1;
    private static final int LOTTO_MAX_NUMBER = 45;

    public static void validate(List<Integer> numbers) {
        validateLottoNumbersSize(numbers);
        validateLottoNumbersDuplicate(numbers);
        validateLottoNumbersOutOfRange(numbers);
    }

    private static void validateLottoNumbersSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateLottoNumbersDuplicate(List<Integer> numbers) {
        if (ValidationUtil.isDuplicateNumbers(numbers)) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateLottoNumbersOutOfRange(List<Integer> numbers) {
        for (Integer num : numbers) {
            if (ValidationUtil.isOutOfRange(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER, num)) {
                throw new IllegalArgumentException();
            }
        }
    }
}