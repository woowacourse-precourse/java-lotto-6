package lotto.model;

import static lotto.util.message.ErrorMessages.BONUS_DUPLICATION_EXCEPTION;

public class WinningNumbers {
    private final Lotto lotto;
    private final Bonus bonus;

    public WinningNumbers(Lotto lotto, Bonus bonus) {
        validate(lotto, bonus);
        this.lotto = lotto;
        this.bonus = bonus;
    }

    private void validate(Lotto lotto, Bonus bonus) {
        if (isDuplicated(lotto, bonus)) {
            throw new IllegalArgumentException(BONUS_DUPLICATION_EXCEPTION);
        }
    }

    private boolean isDuplicated(Lotto lotto, Bonus bonus) {
        return lotto.isContain(bonus.getNumber());
    }
}
