package lotto.model;

import java.util.List;
import lotto.service.Validator;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public static Lotto createLotto(List<Integer> numbers) {
        return new Lotto(numbers);
    }

    private void validate(List<Integer> numbers) {
        Validator.validateInputLength(numbers);
        Validator.duplicateInputWinningNumbers(numbers);
    }


}
