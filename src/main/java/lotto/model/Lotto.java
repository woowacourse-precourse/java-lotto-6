package lotto.model;

import java.util.List;

public class Lotto {
    private final int NUMBERS_SIZE = 6;
    private final int NUMBERS_MIN_RANGE = 1;
    private final int NUMBERS_MAX_RANGE = 45;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        checkNumbersException(numbers);
        this.numbers = numbers;
    }

    private void checkNumbersSizeException(List<Integer> numbers) {
        if (numbers.size() != NUMBERS_SIZE) {
            String NUMBERS_SIZE_ERROR_MESSAGE = "[ERROR] 로또 번호는 " + NUMBERS_SIZE + "개의 숫자여야 합니다.";
            throw new IllegalArgumentException(NUMBERS_SIZE_ERROR_MESSAGE);
        }
    }

    private void checkNumbersDuplicationException(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != NUMBERS_SIZE) {
            String NUMBERS_DUPLICATION_ERROR_MESSAGE = "[ERROR] 로또 번호는 중복되지 않는 " + NUMBERS_SIZE + "개의 숫자여야 합니다.";
            throw new IllegalArgumentException(NUMBERS_DUPLICATION_ERROR_MESSAGE);
        }
    }

    private void checkNumbersRangeException(List<Integer> numbers) {
        if (numbers.stream().anyMatch(n -> n < NUMBERS_MIN_RANGE || n > NUMBERS_MAX_RANGE)) {
            String NUMBERS_RANGE_ERROR_MESSAGE = "[ERROR] 로또 번호는 중복되지 않는 " + NUMBERS_SIZE + "개의 숫자여야 합니다.";
            throw new IllegalArgumentException(NUMBERS_RANGE_ERROR_MESSAGE);
        }
    }

    private void checkNumbersException(List<Integer> numbers) {
        checkNumbersSizeException(numbers);
        checkNumbersDuplicationException(numbers);
        checkNumbersRangeException(numbers);
    }
}
