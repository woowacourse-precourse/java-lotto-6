package lotto.domain;

import lotto.util.Validator;

import java.util.List;

public record Lotto(List<Integer> numbers) {
    public Lotto {
        Validator.validateNumbers(numbers);
    }

    public boolean contains(int value) {
        return numbers.contains(value);
    }
}
