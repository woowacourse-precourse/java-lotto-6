package lotto.domain;

import lotto.enums.ErrorMessages;

import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessages.OVER_MAX_SIZE_MESSAGE.getMessage());
        }
        if (numbers.stream().distinct().count() != 6) {
            throw new IllegalArgumentException(ErrorMessages.DUPLICATE_NUMBER_MESSAGE.getMessage());
        }
    }

    // TODO: 추가 기능 구현
}
