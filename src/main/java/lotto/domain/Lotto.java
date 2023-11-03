package lotto.domain;

import lotto.vo.Number;

import java.util.List;

public class Lotto {
    private final List<Number> numbers;

    public Lotto(final List<Number> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Number> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}