package lotto.exception;

import java.util.List;

public class LottoException extends IllegalArgumentException {
    private static final int NUMBERS_SIZE = 6;
    private static final int NUMBERS_MIN_RANGE = 1;
    private static final int NUMBERS_MAX_RANGE = 45;

    public LottoException(String message) {
        super(message);
    }

    private static void checkNumbersSizeException(List<Integer> numbers) {
        if (numbers.size() != NUMBERS_SIZE) {
            String NUMBERS_SIZE_ERROR_MESSAGE = "[ERROR] 로또 번호는 " + NUMBERS_SIZE + "개의 숫자여야 합니다.";
            throw new LottoException(NUMBERS_SIZE_ERROR_MESSAGE);
        }
    }

    private static void checkNumbersDuplicationException(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != NUMBERS_SIZE) {
            String NUMBERS_DUPLICATION_ERROR_MESSAGE = "[ERROR] 로또 번호는 중복되지 않는 " + NUMBERS_SIZE + "개의 숫자여야 합니다.";
            throw new LottoException(NUMBERS_DUPLICATION_ERROR_MESSAGE);
        }
    }

    private static void checkNumbersRangeException(List<Integer> numbers) {
        if (numbers.stream().anyMatch(n -> n < NUMBERS_MIN_RANGE || n > NUMBERS_MAX_RANGE)) {
            String NUMBERS_RANGE_ERROR_MESSAGE = "[ERROR] 로또 번호는 중복되지 않는 " + NUMBERS_SIZE + "개의 숫자여야 합니다.";
            throw new LottoException(NUMBERS_RANGE_ERROR_MESSAGE);
        }
    }

    public static void checkNumbersException(List<Integer> numbers) {
        checkNumbersSizeException(numbers);
        checkNumbersDuplicationException(numbers);
        checkNumbersRangeException(numbers);
    }
}
