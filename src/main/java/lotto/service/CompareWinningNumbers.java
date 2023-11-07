package lotto.service;

import lotto.Lotto;
import lotto.readUserInput.WinningNumbers;

public class CompareWinningNumbers {
    private Lotto lotto;

    public CompareWinningNumbers(Lotto lotto) {
        this.lotto = lotto;
    }

    public int winningCount() {
        int winningNumberCount = CompareCount.INITIAL_ZERO_COUNT.getCount();
        for (Integer winningNumber : WinningNumbers.numbers) {
            if (lotto.isContainNumber(winningNumber)) {
                winningNumberCount++;
            }
        }
        return winningNumberCount;
    }

    public Reward checkThisTicketRank() {
        int count = winningCount();
        if (count == CompareCount.SIX_MATCH.getCount()) {
            return Reward.FIRST_PLACE;
        } else if (count == CompareCount.FIVE_MATCH.getCount()) {
            CompareBonusNumber compareBonusNumber = new CompareBonusNumber(lotto);
            return compareBonusNumber.isThereBonus();
        } else if (count == CompareCount.FOUR_MATCH.getCount()) {
            return Reward.FOURTH_PLACE;
        } else if (count == CompareCount.THREE_MATCH.getCount()) {
            return Reward.FIFTH_PLACE;
        }
        return Reward.LOSE;
    }


}
