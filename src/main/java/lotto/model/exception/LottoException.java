package lotto.model.exception;

import java.util.List;
import static lotto.model.MagicVariable.NUMBERS_SIZE;
import static lotto.model.MagicVariable.NUMBERS_MIN_RANGE;
import static lotto.model.MagicVariable.NUMBERS_MAX_RANGE;


public class LottoException extends IllegalArgumentException {
    private LottoException(String message) {
        super(message);
    }

    public static void checkNumbersException(List<Integer> numbers) {
        checkNumbersSizeException(numbers);
        checkNumbersDuplicationException(numbers);
        checkNumbersRangeException(numbers);
    }

    private static void checkNumbersSizeException(List<Integer> numbers) {
        if (numbers.size() != NUMBERS_SIZE.getNumber()) {
            String NUMBERS_SIZE_ERROR_MESSAGE = "[ERROR] 로또 번호는 " + NUMBERS_SIZE.getNumber() + "개의 숫자여야 합니다.";
            throw new LottoException(NUMBERS_SIZE_ERROR_MESSAGE);
        }
    }

    private static void checkNumbersDuplicationException(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != NUMBERS_SIZE.getNumber()) {
            String NUMBERS_DUPLICATION_ERROR_MESSAGE = "[ERROR] 로또 번호는 중복되지 않는 " + NUMBERS_SIZE.getNumber() + "개의 숫자여야 합니다.";
            throw new LottoException(NUMBERS_DUPLICATION_ERROR_MESSAGE);
        }
    }

    private static void checkNumbersRangeException(List<Integer> numbers) {
        if (numbers.stream().anyMatch(n -> n < NUMBERS_MIN_RANGE.getNumber() || n > NUMBERS_MAX_RANGE.getNumber())) {
            String NUMBERS_RANGE_ERROR_MESSAGE = "[ERROR] 로또 번호는 중복되지 않는 " + NUMBERS_MIN_RANGE.getNumber() + "과 " + NUMBERS_MAX_RANGE.getNumber() + "사이의 숫자여야 합니다.";
            throw new LottoException(NUMBERS_RANGE_ERROR_MESSAGE);
        }
    }
}
