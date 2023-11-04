package lotto;

import java.util.List;

public class Lotto {
    private static final String INVALID_SIZE_ERROR_MESSAGE = "[ERROR] 로또 숫자는 6개여야 합니다.";
    public static final int LOTTO_SIZE = 6;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (isInvalidSize(numbers)) {
            throw new IllegalArgumentException(INVALID_SIZE_ERROR_MESSAGE);
        }
    }

    private boolean isInvalidSize(List<Integer> numbers) {
        return numbers.size() != LOTTO_SIZE;
    }

}
