package lotto.domain;

import java.util.List;

public class LottoWinningNumber {
    private final List<Integer> winningNumbers;
    private final int specialNumber;

    public LottoWinningNumber(List<Integer> winningNumbers, int specialNumber) {
        validate(winningNumbers);
        this.winningNumbers = winningNumbers;
        this.specialNumber = specialNumber;
    }

    private void validate(List<Integer> winningNumbers) {
        if (winningNumbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }
}
