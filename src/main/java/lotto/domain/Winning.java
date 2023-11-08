package lotto.domain;

import java.util.List;
import lotto.util.NumberValidator;

public class Winning {
    private final List<Integer> numbers;

    public Winning(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        NumberValidator.verifyWinningNumbers(numbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
