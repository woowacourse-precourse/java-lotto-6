package lotto.service;

import lotto.Lotto;
import lotto.readUserInput.WinningNumbers;

public class CompareWinningNumbers {
    private Lotto lotto;

    public CompareWinningNumbers(Lotto lotto) {
        this.lotto = lotto;
    }

    public int winningCount() {
        int winningNumberCount = 0;
        for (Integer winningNumber : WinningNumbers.numbers) {
            if (lotto.isContainNumber(winningNumber)) {
                winningNumberCount++;
            }
        }
        return winningNumberCount;
    }


}
