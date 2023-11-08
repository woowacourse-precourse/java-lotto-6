package lotto.domain;

import lotto.validation.DomainValidate;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validate(List<Integer> numbers) {
        for (Integer number : numbers) {
            DomainValidate.validateNumberInRange(number);
        }
        DomainValidate.validateNumberOfWinningNumbers(numbers);
        DomainValidate.validateDuplicated(numbers);
    }
}
