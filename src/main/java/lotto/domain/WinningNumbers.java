package lotto.domain;

import java.util.List;

public class WinningNumbers {
    private final List<Integer> winningNumbers;

    private final Integer bonusNumber;

    private WinningNumbers(List<Integer> winningNumbers, Integer bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public WinningNumbers from(List<Integer> winningNumbers, Integer bonusNumber) {
        return new WinningNumbers(winningNumbers, bonusNumber);
    }
}
