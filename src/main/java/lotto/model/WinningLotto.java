package lotto.model;

import lotto.utils.ExceptionMessage;

public class WinningLotto {

    private final Lotto lotto;
    private final Bonus bonus;

    public WinningLotto(Lotto lotto, Bonus bonus) {
        validate(lotto, bonus);
        this.lotto = lotto;
        this.bonus = bonus;
    }

    private void validate(Lotto lotto, Bonus bonus) {
        validateBonusNotInLotto(lotto, bonus);
    }

    private void validateBonusNotInLotto(Lotto lotto, Bonus bonus) {
        if (lotto.contains(bonus.bonusNumber())) {
            throw new IllegalArgumentException(
                ExceptionMessage.INVALID_BONUS_DUPLICATION.getMessage());
        }
    }

}
