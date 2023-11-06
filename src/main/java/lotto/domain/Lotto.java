package lotto.domain;

import java.util.List;
import lotto.util.Censor;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        Censor.validateLotto(numbers);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
