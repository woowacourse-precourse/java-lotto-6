package lotto.domain;

import static lotto.exception.Message.BONUS_NUMBER_DUPLICATION_EXCEPTION;

import lotto.Lotto;

public class Bonus {

    private final int bonusNumber;

    public Bonus(Lotto winnerLotto, int bonusNumber) {
        validateDuplication(winnerLotto, bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validateDuplication(Lotto winnerLotto, int bonusNumber) {
        if (isDuplicated(winnerLotto, bonusNumber)) {
            throw new IllegalArgumentException(BONUS_NUMBER_DUPLICATION_EXCEPTION);
        }
    }

    private boolean isDuplicated(Lotto winnerLotto, int bonusNumber) {
        return winnerLotto.isOverlapping(bonusNumber);
    }
}
