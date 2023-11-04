package lotto.domain;

import java.util.List;

public class WinningNumber {
    private List<Integer> winningNumbers;
    private int bonusNumber;
    public WinningNumber(final List<Integer> winningNumbers, final int bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }
}
