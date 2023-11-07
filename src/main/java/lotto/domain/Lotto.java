package lotto.domain;

import lotto.validation.DuplicateNumberValidator;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }

        DuplicateNumberValidator.validateDuplicateNumbers(numbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
