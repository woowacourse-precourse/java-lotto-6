package lotto.domain;

import lotto.util.exception.ErrorCode;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateLottoSize(numbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validateLottoSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorCode.INVALID_LOTTO_NUMBER_COUNT.getMessage());
        }
    }
}
