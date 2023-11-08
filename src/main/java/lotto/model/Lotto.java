package lotto.model;

import java.util.Collections;
import java.util.List;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }

    private void validate(List<Integer> numbers) {
        LottoNumberValidator.validateNumbersSize(numbers);
        LottoNumberValidator.validateNumberRange(numbers);
        LottoNumberValidator.validateDuplicateNumbers(numbers);
    }

    @Override
    public String toString() {
        return "[" + String.join(", ", numbers.stream().map(String::valueOf).toArray(String[]::new)) + "]";
    }
}
