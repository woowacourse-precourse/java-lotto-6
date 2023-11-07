package lotto.model;

import java.util.List;
import lotto.validator.Validator;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
        this.numbers.sort(Integer::compareTo);
    }

    private void validate(List<Integer> numbers) {
        Validator.validateLotto(numbers);
    }
}
