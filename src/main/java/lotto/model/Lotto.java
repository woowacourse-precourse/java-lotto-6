package lotto.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.controller.Validation;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        Validation.validateLottoSize(numbers);
        Validation.validateLottoRange(numbers);
        Validation.validateLottoDuplication(numbers);
    }

    public List<Integer> numbers() {
        return numbers;
    }
}
