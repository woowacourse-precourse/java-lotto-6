package lotto.domain;

import java.util.List;
import lotto.constants.Constants;

public class BonusNumber {
    private final int bonusNumber;

    public BonusNumber(List<Integer> winningNumber, int bonusNumber) {
        isDifferentOne(winningNumber, bonusNumber);
        isInRange(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    private void isDifferentOne(List<Integer> winningNumber, int bonusNumber) {
        if (winningNumber.contains(bonusNumber)) {
            throw new IllegalArgumentException(Constants.ERROR_MESSAGE);
        }
    }

    private void isInRange(int bonusNumber) {
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException(Constants.ERROR_MESSAGE);
        }
    }
}
