package lotto.domain;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate();
        this.numbers = numbers;
    }

    public void validate() {
        validateNumberOfNumber(numbers);
    }

    private void validateNumberOfNumber(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }
}

