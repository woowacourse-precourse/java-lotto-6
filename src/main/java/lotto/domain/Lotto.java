package lotto.domain;

import java.util.List;
import lotto.constant.ErrorMessage;
import lotto.util.NumberValidator;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        NumberValidator.validateSizeSix(numbers);
        NumberValidator.validateNumbersRange(numbers);
        NumberValidator.validateDuplicates(numbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
