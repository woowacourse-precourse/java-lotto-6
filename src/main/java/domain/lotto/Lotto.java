package domain.lotto;

import static domain.lotto.LottoInfoNumbers.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        /*validateSize(numbers);
        validateDuplicate(numbers);*/
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        Validation.validateLengthOfList(numbers, LOTTO_TOTAL_NUMBER);
        Validation.validateDuplicate(numbers);
        Validation.validateListWithinRange(numbers);
    }

    /*private void validateSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_TOTAL_NUMBER) {
            throw new IllegalArgumentException();
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        Set<Integer> nonDuplicateNumbers = new HashSet<>(numbers);
        if (nonDuplicateNumbers.size() != LOTTO_TOTAL_NUMBER) {
            throw new IllegalArgumentException();
        }
    }*/

}
