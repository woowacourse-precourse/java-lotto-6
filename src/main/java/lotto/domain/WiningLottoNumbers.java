package lotto.domain;

import static lotto.ErrorMessage.BONUS_DUPLICATION_ERROR_MESSAGE;

public class WiningLottoNumbers {
    private final Lotto winingLotto;
    private final Bonus bonus;

    public WiningLottoNumbers(Lotto winingLotto, Bonus bonus) {
        validate(winingLotto, bonus);
        this.winingLotto = winingLotto;
        this.bonus = bonus;
    }
    

    private void validate(Lotto lotto, Bonus bonus) {
        if (hasBonusNumberInLotto(lotto, bonus)) {
            throwException(BONUS_DUPLICATION_ERROR_MESSAGE.get());
        }
    }

    private boolean hasBonusNumberInLotto(Lotto lotto, Bonus bonus) {
        return lotto.hasNumber(bonus.get());
    }

    private void throwException(String errorMessage) {
        throw new IllegalArgumentException(errorMessage);
    }
}
