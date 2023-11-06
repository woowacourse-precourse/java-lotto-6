package lotto.domain.vo;

import java.util.List;
import lotto.util.validator.InputValidator;

public class WinningNumbers {
    private final List<Integer> numbers;

    private WinningNumbers(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public static WinningNumbers of(List<Integer> numbers, InputValidator<List<Integer>> validator) {
        validator.validate(numbers);
        return new WinningNumbers(numbers);
    }
}
