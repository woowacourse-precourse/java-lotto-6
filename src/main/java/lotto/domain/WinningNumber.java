package lotto.domain;

import java.util.List;
import lotto.Lotto;
import lotto.utils.ExceptionMessage;

public class WinningNumber {

    private Lotto winningLotto;
    private int bonusNumber;

    public void createWinningNumber(List<Integer> numbers) {
        winningLotto = new Lotto(numbers);
    }

    public void creatBonusNumber(int bonusNumber) {
        validateNumberRange(bonusNumber);
        validateDuplicate(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validateNumberRange(int bonusNumber) {
        if (bonusNumber < 1 || 45 < bonusNumber) {
            throw new IllegalArgumentException(ExceptionMessage.ERROR_NUMBER_RANGE);
        }
    }

    private void validateDuplicate(int bonusNumber) {
        if (winningLotto.hasBonusNumber(bonusNumber)) {
            throw new IllegalArgumentException(ExceptionMessage.ERROR_BONUS_NUMBER_WINNER_NUMBER_DUPLICATE);
        }
    }
}
