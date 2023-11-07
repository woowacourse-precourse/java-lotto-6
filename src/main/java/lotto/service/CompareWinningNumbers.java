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

    public Reward checkThisTicketRank() {
        int count = winningCount();
        if (count == 6) {
            return Reward.FIRST_PLACE;
        } else if (count == 5) {
            CompareBonusNumber compareBonusNumber = new CompareBonusNumber(lotto);
            return compareBonusNumber.isThereBonus();
        } else if (count == 4) {
            return Reward.FOURTH_PLACE;
        } else if (count == 3) {
            return Reward.FIFTH_PLACE;
        }
        return Reward.LOSE;
    }


}
