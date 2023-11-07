package lotto.domain.lotto;

import lotto.global.util.Validation;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        Validation validation = new Validation();
        validation.isSixNumbers(numbers);
        validation.hasDuplicateNumbers(numbers);
        validation.isNumbersInRangeOf1To45(numbers);
    }
}
