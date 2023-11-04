package lotto.domain;

import lotto.exception.InputException;
import java.util.List;

import static lotto.configuration.GameConfiguration.LOTTO_NUMBER_SIZE;
import static lotto.exception.errorcode.InputErrorCode.INVALID_LOTTO_NUMBERS_SIZE;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_SIZE) {
            throw new InputException(INVALID_LOTTO_NUMBERS_SIZE);
        }
    }

    // TODO: 추가 기능 구현
}
