package lotto.domain;

import lotto.message.ExceptionMessage;

import java.util.ArrayList;
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
            throw new IllegalArgumentException(ExceptionMessage.IS_NOT_6_LENGTH_OF_LOTTO.toString());
        }
    }

    public List<Integer> getNumbers() {
        Collections.sort(numbers);
        return new ArrayList<>(numbers);
    }

    // TODO: 추가 기능 구현
}
