package lotto.model;

import java.util.List;
import lotto.utils.InputValidator;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        InputValidator.checkLotto(numbers);
    }

}
