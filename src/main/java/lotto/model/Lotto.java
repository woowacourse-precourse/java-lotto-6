package lotto.model;

import java.util.List;

public class Lotto {

    private static final int LOTTO_SIZE = 6;

    private static final String COMMON_ERROR_MESSAGE = "[ERROR] ";
    private static final String INVALID_LOTTO_SIZE_MESSAGE = COMMON_ERROR_MESSAGE + "로또는 서로 다른 숫자 6자여야 합니다.";

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(INVALID_LOTTO_SIZE_MESSAGE);
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
