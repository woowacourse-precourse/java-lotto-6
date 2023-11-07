package lotto.domain;

import java.util.List;
import lotto.validator.Validator;

public class WinningNumbers {

    private final List<Integer> numbers;

    public WinningNumbers(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        Validator.validateNumberCount(numbers);
        Validator.validateNumberRange(numbers);
        Validator.validateDuplicateNumber(numbers);
    }

    public int match(Lotto lotto) {
        return (int) lotto.getStream()
                .filter(numbers::contains)
                .count();
    }

    public boolean contains(int number) {
        return numbers.contains(number);
    }
}
