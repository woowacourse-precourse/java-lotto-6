package lotto.domain;

import java.util.List;
import lotto.constants.messages.Error;
import lotto.constants.LottoStatus;

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
            throw new IllegalArgumentException(Error.DUPLICATE_NUMBERS);
        }
    }

    private void isInRange(int bonusNumber) {
        if (bonusNumber < LottoStatus.MIN_VALUE || bonusNumber > LottoStatus.MAX_VALUE) {
            throw new IllegalArgumentException(Error.OUT_OF_RANGE);
        }
    }
}
