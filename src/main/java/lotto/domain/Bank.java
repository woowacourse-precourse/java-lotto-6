package lotto.domain;

import java.util.List;

public class Bank {
    private int extraWinningNumber;
    private List<Integer> winningNumbers;

    public void setExtraWinningNumber(int extraWinningNumber) {
        this.extraWinningNumber = extraWinningNumber;
    }

    public void setWinningNumbers(List<Integer> winningNumbers) {
        this.winningNumbers = winningNumbers;
    }
}
