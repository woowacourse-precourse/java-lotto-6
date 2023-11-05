package lotto.domain;

import java.util.List;
import lotto.utils.Utils;
import lotto.utils.Validation;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = Utils.sortListAscending(numbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validate(List<Integer> numbers) {
        Validation.validateListNumberCount(numbers, 6);
        Validation.validateListNumberInRange(numbers, 1, 45);
        Validation.validateListNumberNotDuplicated(numbers);
    }
}
