package domain;

import static domain.LottoInfoNumbers.*;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validate(List<Integer> numbers) {
        Validation.validateLengthOfList(numbers, LOTTO_TOTAL_NUMBER);
        Validation.validateDuplicate(numbers);
        Validation.validateListWithinRange(numbers);
    }
}
