package lotto.domain;

import java.util.List;
import lotto.common.validate.Validate;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateNumbers(numbers);
        this.numbers = numbers;
    }

    private void validateNumbers(List<Integer> numbers) {
        Validate.lottoDomainValidate(numbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
