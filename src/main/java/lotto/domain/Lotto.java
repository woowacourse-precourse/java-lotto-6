package lotto.domain;

import java.util.List;

public class Lotto {

    private static final int NUMBERS_LENGTH = 6;
    private static final String LENGTH_ERROR_MESSAGE = "[ERROR] 로또 번호는 6개여야 합니다.";

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateNumbersSize(numbers);
    }

    private static void validateNumbersSize(final List<Integer> numbers) {
        if (numbers.size() != NUMBERS_LENGTH) {
            throw new IllegalArgumentException(LENGTH_ERROR_MESSAGE);
        }
    }

    // TODO: 추가 기능 구현
}
