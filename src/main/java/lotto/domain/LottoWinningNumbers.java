package lotto.domain;

import java.util.Collections;
import java.util.List;

public class LottoWinningNumbers {

    private final List<Integer> numbers;

    public LottoWinningNumbers(List<Integer> numbers) {
        validateDuplicateNumbers(numbers);
        this.numbers = numbers;
    }

    private void validateDuplicateNumbers(List<Integer> numbers) {
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }
}
