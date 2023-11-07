package lotto.domain;

import java.util.List;
import lotto.validation.LottoValidator;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        LottoValidator validator = new LottoValidator();

        validator.validate(numbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
