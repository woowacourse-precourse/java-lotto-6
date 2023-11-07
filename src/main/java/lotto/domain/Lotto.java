package lotto.domain;

import java.util.List;
import lotto.validator.Validator;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        Validator.validateSize(numbers);
        Validator.validateRange(numbers);
        Validator.validateDuplicate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
