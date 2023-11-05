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

    public String checkThisTicketRank() {
        if (winningCount() == 6) {
            return "1st";
        } else if (winningCount() == 5) {
            CompareBonusNumber compareBonusNumber = new CompareBonusNumber(lotto);
            return compareBonusNumber.isThereBonus();
        } else if (winningCount() == 4) {
            return "4nd";
        } else if (winningCount() == 3) {
            return "5nd";
        }
        return "lose";
    }


}
