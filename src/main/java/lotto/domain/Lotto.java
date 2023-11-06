package lotto.domain;

import java.util.List;
import lotto.common.Validation;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        Validation.lottoSize(numbers);
        Validation.lottoDuplicate(numbers);
        Validation.lottoLimit(numbers);
    }

    private List<Integer> getNumbers() {
        return numbers;
    }
}
