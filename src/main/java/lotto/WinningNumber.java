package lotto;

import java.util.List;

public class WinningNumber {

    private final List<Integer> numbers;

    public static WinningNumber from(List<Integer> numbers) {
        return new WinningNumber(numbers);
    }

    private WinningNumber(List<Integer> numbers) {
        Validator.validateNumbersSize(numbers);
        Validator.validateIsDuplicationExists(numbers);
        this.numbers = numbers;
    }

    public boolean contains(int bonusNumber) {
        return numbers.contains(bonusNumber);
    }
}