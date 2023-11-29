package lotto.model;

import java.util.List;
import lotto.constant.ValidateMessage;

public class BonusNumber {
    private final int bonusNumber;

    public BonusNumber(WinnerNumber winnerNumber, int bonusNumber) {
        isBetween1And45(bonusNumber);
        isDuplicate(winnerNumber.getWinnerNumbers(), bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void isBetween1And45(int bonusNumber) {
        if (bonusNumber < 1 || bonusNumber > 45) {
            ValidateMessage.BONUS_NUMBER_IS_BETWEEN_1_TO_45.throwException();
        }
    }

    private void isDuplicate(List<Integer> winnerNumbers, int bonusNumber) {
        for (Integer winnerNumber : winnerNumbers) {
            if (winnerNumber == bonusNumber) {
                ValidateMessage.BONUS_NUMBER_IS_DUPLICATE.throwException();
            }
        }
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
