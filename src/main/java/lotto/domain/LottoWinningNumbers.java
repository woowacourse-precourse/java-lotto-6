package lotto.domain;

import java.util.List;

public class LottoWinningNumbers {
    private final List<Integer> winningNumbers;

    public LottoWinningNumbers(List<Integer> winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

}
