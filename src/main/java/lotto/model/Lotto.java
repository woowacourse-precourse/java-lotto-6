package lotto.model;

import lotto.validator.LottoNumberValidator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        LottoNumberValidator.validate(numbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

}
