package lotto.domain;

import static common.ErrorCode.LOTTO_NUMBERS_INVALID_SIZE;

import common.exception.InvalidArgumentException;
import java.util.List;

public class Lotto {

    public static final int NUMBERS_SIZE = 6;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (!isValidSize(numbers)) {
            throw new InvalidArgumentException(LOTTO_NUMBERS_INVALID_SIZE);
        }
    }

    private boolean isValidSize(List<Integer> numbers) {
        return numbers.size() == NUMBERS_SIZE;
    }

    // TODO: 추가 기능 구현
}
