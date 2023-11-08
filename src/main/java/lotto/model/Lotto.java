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
        StringBuilder result = new StringBuilder("[");
        for (int i = 0; i < numbers.size(); i++) {
            result.append(numbers.get(i));
            if (i < numbers.size() - 1) {
                result.append(", ");
            }
        }
        result.append("]");
        return result.toString();
    }
}
