package lotto;

import java.util.List;

public class LottoChecker {

    private final List<Integer> winningNumbers;

    public LottoChecker(List<Integer> winningNumbers) {
        validate(winningNumbers);
        this.winningNumbers = winningNumbers;
    }

    private void validate(List<Integer> winningNumbers) {
        if (winningNumbers.size() != 6) {
            throw new IllegalArgumentException();
        }
        winningNumbers.forEach(this::validateNumberRange);
    }

    private void validateNumberRange(Integer number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException();
        }
    }
}
