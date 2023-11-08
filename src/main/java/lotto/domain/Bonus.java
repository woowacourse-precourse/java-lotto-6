package lotto.domain;

import static lotto.constant.LottoConstant.LOTTO_END_NUMBER;
import static lotto.constant.LottoConstant.LOTTO_START_NUMBER;
import static lotto.exception.Message.BONUS_NUMBER_DUPLICATION_EXCEPTION;
import static lotto.exception.Message.BONUS_NUMBER_RANGE_EXCEPTION;

public class Bonus {

    private final int bonusNumber;

    public Bonus(Lotto winnerLotto, int bonusNumber) {
        validateRange(bonusNumber);
        validateDuplication(winnerLotto, bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validateRange(int bonusNumber) {
        if (outOfRange(bonusNumber)) {
            throw new IllegalArgumentException(BONUS_NUMBER_RANGE_EXCEPTION);
        }
    }

    private boolean outOfRange(int bonusNumber) {
        return bonusNumber < LOTTO_START_NUMBER || bonusNumber > LOTTO_END_NUMBER;
    }

    private void validateDuplication(Lotto winnerLotto, int bonusNumber) {
        if (isDuplicated(winnerLotto, bonusNumber)) {
            throw new IllegalArgumentException(BONUS_NUMBER_DUPLICATION_EXCEPTION);
        }
    }

    private boolean isDuplicated(Lotto winnerLotto, int bonusNumber) {
        return winnerLotto.isOverlapping(bonusNumber);
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
