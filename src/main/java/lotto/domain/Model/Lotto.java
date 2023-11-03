package lotto.domain.Model;

import lotto.domain.Utility.Constant;
import lotto.domain.Utility.Validator;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        Validator.validateNumbers(numbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
