package lotto.domain;

import java.util.List;

public class Lotto {
    static final String LOTTO_START_ERROR_MESSAGE = "[ERROR] ";
    static final String LOTTO_NUMBER_LENGTH_INVALID_MESSAGE = "발행한 로또 번호는 6자리 숫자여야 합니다.";
    static final String LOTTO_NUMBER_RANGE_INVALID_MESSAGE = "발행한 로또 번호는 1~45의 숫자여야 합니다.";
    static final String LOTTO_NUMBER_DUPLICATE_INVALID_MESSAGE = "발행한 로또 번호는 중복이 있으면 안됩니다.";
    private static final int LOTTO_SIX_SIZE = 6;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateLengthNumber(numbers);
        validateRange(numbers);
        validateDuplication(numbers);
    }

    private static void validateLengthNumber(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIX_SIZE) {
            throw new IllegalArgumentException(LOTTO_START_ERROR_MESSAGE + LOTTO_NUMBER_LENGTH_INVALID_MESSAGE);
        }
    }

    private static void validateRange(List<Integer> numbers) {
        if (isOverRange(numbers)) {
            throw new IllegalArgumentException(LOTTO_START_ERROR_MESSAGE + LOTTO_NUMBER_RANGE_INVALID_MESSAGE);
        }
    }

    private static boolean isOverRange(List<Integer> numbers) {
        long numberCount = numbers.stream()
                .filter(number -> number < 1 || number > 45)
                .count();
        return numberCount != 0;
    }

    private static void validateDuplication(List<Integer> numbers) {
        if (isDuplication(numbers)) {
           throw new IllegalArgumentException(LOTTO_START_ERROR_MESSAGE + LOTTO_NUMBER_DUPLICATE_INVALID_MESSAGE);
        };
    }

    private static boolean isDuplication(List<Integer> numbers) {
        long duplication = numbers.stream()
                .distinct()
                .count();
        return duplication != LOTTO_SIX_SIZE;
    }
}
