package lotto.model.exception;

import java.util.List;
import static lotto.model.enums.MagicVariable.NUMBERS_SIZE;
import static lotto.model.enums.MagicVariable.NUMBERS_MIN_RANGE;
import static lotto.model.enums.MagicVariable.NUMBERS_MAX_RANGE;
import static lotto.model.enums.ErrorMessage.NUMBERS_SIZE_ERROR_MESSAGE;
import static lotto.model.enums.ErrorMessage.NUMBERS_DUPLICATION_ERROR_MESSAGE;
import static lotto.model.enums.ErrorMessage.NUMBERS_RANGE_ERROR_MESSAGE;


public class LottoException extends IllegalArgumentException {
    private LottoException(String message) {
        super(message);
    }

    public static void checkNumbersExceptions(List<Integer> numbers) {
        checkNumbersSizeException(numbers);
        checkNumbersDuplicationException(numbers);
        checkNumbersRangeException(numbers);
    }

    private static void checkNumbersSizeException(List<Integer> numbers) {
        if (numbers.size() != NUMBERS_SIZE.getNumber()) {
            throw new LottoException(NUMBERS_SIZE_ERROR_MESSAGE.getErrorMessage());
        }
    }

    private static void checkNumbersDuplicationException(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != NUMBERS_SIZE.getNumber()) {
            throw new LottoException(NUMBERS_DUPLICATION_ERROR_MESSAGE.getErrorMessage());
        }
    }

    private static void checkNumbersRangeException(List<Integer> numbers) {
        if (numbers.stream().anyMatch(n -> n < NUMBERS_MIN_RANGE.getNumber() || n > NUMBERS_MAX_RANGE.getNumber())) {
            throw new LottoException(NUMBERS_RANGE_ERROR_MESSAGE.getErrorMessage());
        }
    }
}
