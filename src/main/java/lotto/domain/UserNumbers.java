package lotto.domain;

import lotto.util.InputUtil;
import lotto.validation.DomainValidate;

import java.util.List;

public class UserNumbers {
    private List<Integer> numbers;

    public UserNumbers(List<Integer> numbers) {
        this.numbers = inputNumbers(numbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private List<Integer> inputNumbers(List<Integer> numbers) {
        try {
            validate(numbers);
            return numbers;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputNumbers(InputUtil.enterNumbersWhileVerifying());
        }
    }

    protected void validate(List<Integer> numbers) {
        for (Integer number : numbers) {
            DomainValidate.validateNumberInRange(number);
        }
        DomainValidate.validateDuplicated(numbers);
    }
}
