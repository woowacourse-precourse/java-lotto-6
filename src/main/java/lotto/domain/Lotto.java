package lotto.domain;

import java.util.List;
import lotto.utils.Validation;


public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        Validation.validateLotto(numbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
