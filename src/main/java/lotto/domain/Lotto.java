package lotto.domain;

import lotto.util.ExceptionMessage;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ExceptionMessage.NOT_SIX_SIZE);
        }
    }

    // TODO: 추가 기능 구현
}
