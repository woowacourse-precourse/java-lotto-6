package lotto.Domain;

import java.util.Collections;
import java.util.List;
import lotto.Util.Validation;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        Validation.validateNumbers(numbers);
    }

    private void sortNumbers(List<Integer> numbers) {
        Collections.sort(numbers);
    }

    public List<Integer> getNumbers() {
        sortNumbers(this.numbers);
        return this.numbers;
    }
}
