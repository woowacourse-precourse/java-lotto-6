package lotto.domain;

import java.util.List;

public class WinningNumbers {
    private final List<Integer> numbers;

    public WinningNumbers(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateLotto(numbers);}

    private void validateLotto(List<Integer> numbers) {
        Lotto lotto = new Lotto(numbers);
        lotto.validate(numbers);
    }
}
