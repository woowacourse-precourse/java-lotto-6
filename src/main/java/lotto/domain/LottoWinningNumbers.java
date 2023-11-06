package lotto.domain;

import java.util.Collections;
import java.util.List;

public class LottoWinningNumbers {

    private final List<Integer> numbers;

    public LottoWinningNumbers(List<Integer> numbers) {
        validateNumbersCount(numbers);
        validateDuplicateNumbers(numbers);
        this.numbers = numbers;
    }

    private void validateNumbersCount(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호를 6개 적어주세요.");
        }
    }

    private void validateDuplicateNumbers(List<Integer> numbers) {
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }
}
