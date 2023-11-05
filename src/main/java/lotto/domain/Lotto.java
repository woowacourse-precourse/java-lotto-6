package lotto.domain;

import java.util.List;

import lotto.validator.NumberValidator;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> choiceNumbers) {
        NumberValidator.validateUserNumbersSize(choiceNumbers);
        this.numbers = choiceNumbers;
    }

}
