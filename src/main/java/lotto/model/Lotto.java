package lotto.model;

import java.util.List;
import lotto.validator.ValidatorForModel;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        ValidatorForModel validator = new ValidatorForModel();
        validator.validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getLottoNumbers() {
        return numbers;
    }
}