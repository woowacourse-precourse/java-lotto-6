package lotto;

import java.util.List;

import static lotto.constants.ConstantValues.*;
import static lotto.constants.ErrorMessages.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_LENGTH.getValue()) {
            throw new IllegalArgumentException(ERROR_HEADER.getMessage() + LOTTO_LENGTH_ERROR.getMessage());
        }
    }

    // TODO: 추가 기능 구현
}
