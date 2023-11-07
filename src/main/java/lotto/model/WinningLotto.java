package lotto.model;

import lotto.utils.ExceptionMessage;

public record WinningLotto(Lotto lotto, Bonus bonus) {

    public WinningLotto {
        validate(lotto, bonus);
    }

    private void validate(Lotto lotto, Bonus bonus) {
        validateBonusNotInLotto(lotto, bonus);
    }

    private void validateBonusNotInLotto(Lotto lotto, Bonus bonus) {
        if (lotto.contains(bonus.bonusNumber())) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_BONUS_DUPLICATION.getMessage());
        }
    }


}
