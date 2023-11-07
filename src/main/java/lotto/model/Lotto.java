package lotto.model;

import lotto.util.Validator;
import lotto.view.InputView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public Lotto(String numbers) {
        List<String> strNumbers = Arrays.asList(numbers.split(","));
        this.numbers = validation(strNumbers);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
        Validator.duplicateNumber(numbers);
    }

    private List<Integer> validation(List<String> numbers) {
        List<Integer> intNumbers = Validator.isDigit(numbers);
        Validator.outOfRange(intNumbers);
        Validator.duplicateNumber(intNumbers);
        return intNumbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

}
