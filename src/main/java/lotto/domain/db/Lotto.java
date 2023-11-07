package lotto.domain.db;


import lotto.constant.Phrases;
import lotto.exception.winningNumber.WinningNumberException;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateSize(numbers);
        validateOverRange(numbers);
        validateDuplication(numbers);
        this.numbers = numbers;
    }

    private void validateSize(List<Integer> numbers) {
        new WinningNumberException().numberSizeOver(numbers);
    }

    private void validateOverRange(List<Integer> numbers) {
        new WinningNumberException().overRange(numbers);
    }

    private void validateDuplication(List<Integer> numbers) {
        new WinningNumberException().numberDuplication(numbers);
    }

    public List<Integer> getLottoNumbers() {
        return numbers;
    }
}
