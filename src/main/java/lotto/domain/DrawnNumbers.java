package lotto.domain;

import java.util.List;

public class DrawnNumbers {
    private final List<Integer> winningNumbers;

    private final Integer bonusNumber;

    private DrawnNumbers(List<Integer> winningNumbers, Integer bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public DrawnNumbers from(List<Integer> winningNumbers, Integer bonusNumber) {
        return new DrawnNumbers(winningNumbers, bonusNumber);
    }
}
