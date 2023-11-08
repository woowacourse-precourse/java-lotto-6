package lotto.model.lottoPick;

import lotto.model.enums.NumberStatus;

public class PickedLotto {
    private final WinningNumbers winningNumbers;
    private final Integer bonusNumber;

    public PickedLotto(WinningNumbers winningNumbers, Integer bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public NumberStatus judgeNumber(Integer number) {
        if (winningNumbers.hasNumber(number)) {
            return NumberStatus.CORRECT;
        }
        if (bonusNumber.equals(number)) {
            return NumberStatus.BONUS;
        }
        return NumberStatus.NOTHING;
    }
}
