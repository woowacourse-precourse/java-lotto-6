package lotto.domain;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = Utils.ascendingOrder(numbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validate(List<Integer> numbers) {
        Validations.validateLengthOfList(numbers, LottoInfoNumbers.LOTTO_TOTAL_NUMBER);
        Validations.validateDuplicate(numbers);
        Validations.validateListWithinRange(numbers);
    }
}
