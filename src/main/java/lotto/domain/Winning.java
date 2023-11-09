package lotto.domain;

import lotto.exception.InputException;

import static lotto.exception.errorcode.InputErrorCode.INCLUDE_BONUS_NUMBER_IN_WINNING_NUMBER;

public class Winning {
    private final Lotto lotto;
    private final Bonus bonus;

    public Winning(final Lotto lotto, final Bonus bonus) {
        validateLottoNumberContainBonusNumber(lotto, bonus);
        this.lotto = lotto;
        this.bonus = bonus;
    }

    public int getMatchedCount(final Lotto other) {
        return lotto.getMatchedCount(other);
    }

    public boolean containBonusNumber(final Lotto other) {
        return bonus.containNumber(other);
    }

    private void validateLottoNumberContainBonusNumber(final Lotto lotto, final Bonus bonus) {
        if (bonus.containNumber(lotto)) {
            throw new InputException(INCLUDE_BONUS_NUMBER_IN_WINNING_NUMBER);
        }
    }
}
