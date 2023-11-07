package lotto.lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import lotto.exception.Validator;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        Validator.VALIDATOR.getLottoValidator().sizeValidate(numbers);
        Validator.VALIDATOR.getLottoValidator().duplicatedValidation(numbers);
        Validator.VALIDATOR.getLottoValidator().rangeValidation(numbers);
        this.numbers = new ArrayList<>(numbers);
        Collections.sort(this.numbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
