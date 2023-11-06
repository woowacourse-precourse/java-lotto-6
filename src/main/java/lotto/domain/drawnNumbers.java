package lotto.domain;

import java.util.List;

public class drawnNumbers {
    private final List<Integer> winningNumbers;

    private final Integer bonusNumber;

    private drawnNumbers(List<Integer> winningNumbers, Integer bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public drawnNumbers from(List<Integer> winningNumbers, Integer bonusNumber) {
        return new drawnNumbers(winningNumbers, bonusNumber);
    }
}
