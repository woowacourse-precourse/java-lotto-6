package lotto;

import static lotto.util.Validator.validateDuplicateNumber;
import static lotto.util.Validator.validateNumberMinimumOrMaximum;
import static lotto.util.Validator.validateSizeMiss;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateSizeMiss(numbers);
        validateNumberMinimumOrMaximum(numbers);
        validateDuplicateNumber(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
