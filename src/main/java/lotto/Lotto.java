package lotto;

import java.util.List;

import lotto.validation.InputException;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(final List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(final List<Integer> numbers) {
        InputException.notSixNumberInput(numbers);
        InputException.numberDuplicate(numbers);
    }

    public final List<Integer> getNumbers() {
        return this.numbers;
    }
}
