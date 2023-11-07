package lotto;

import lotto.validator.InputValidator;

import java.util.List;

import static lotto.utility.StringUtil.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (!InputValidator.isValidNumberCount(numbers))
            throw new IllegalArgumentException(PRINT_ERR_NUMBER_INVALID_COUNT.getMessage());

        if (InputValidator.hasDuplicates(numbers))
            throw new IllegalArgumentException(PRINT_ERR_WINNING_NUMBER_DUPLICATE.getMessage());

        if (!InputValidator.isValidNumberRange(numbers)) {
            throw new IllegalArgumentException(PRINT_ERR_NUMBER_INVALID_RANGE.getMessage());
        }
    }

    // TODO: 추가 기능 구현

    public List<Integer> getNumbers() {
        return this.numbers;
    }
}
