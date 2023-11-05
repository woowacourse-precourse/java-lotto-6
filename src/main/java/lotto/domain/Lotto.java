package lotto.domain;

import java.util.List;

public class Lotto {
    private final List<Number> numbers;

    public Lotto(List<Number> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Number> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
}
