package lotto;

import static lotto.util.Validator.validateAlreadyHasNumber;
import static lotto.util.Validator.validateDuplicateNumber;
import static lotto.util.Validator.validateListNumberMinimumOrMaximum;
import static lotto.util.Validator.validateSizeMiss;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateSizeMiss(numbers);
        validateListNumberMinimumOrMaximum(numbers);
        validateDuplicateNumber(numbers);
        this.numbers = numbers;
    }

    /*private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }*/

    public void checkBonusNumber (Integer bonusNumber) {
        validateAlreadyHasNumber(this.numbers, bonusNumber);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
