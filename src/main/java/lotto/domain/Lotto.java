package lotto.domain;

import lotto.util.ExceptionMessage;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
        Set<Integer> temp = new HashSet<>(numbers);
        if (numbers.size() != temp.size()) {
            throw new IllegalArgumentException(ExceptionMessage.DUPLICATE_EXISTS);
        }
    }

    // TODO: 추가 기능 구현
}
