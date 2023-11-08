package lotto.domain;

import java.util.List;
import lotto.validator.WinningNumbersValidator;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        WinningNumbersValidator.validateDuplicateNumber(numbers);
        WinningNumbersValidator.validateMinNumber(numbers);
        WinningNumbersValidator.validateMaxNumber(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
