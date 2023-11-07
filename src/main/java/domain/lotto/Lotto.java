package domain.lotto;

import static domain.lotto.LottoInfoNumbers.*;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        Validation.validateLengthOfList(numbers, LOTTO_TOTAL_NUMBER);
        Validation.validateDuplicate(numbers);
        Validation.validateListWithinRange(numbers);
    }
}
