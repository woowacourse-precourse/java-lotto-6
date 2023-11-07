package lotto.domain;

import static lotto.ErrorMessage.BONUS_DUPLICATION_ERROR_MESSAGE;

public class WinningLottoNumbers {
    private final Lotto winingLotto;
    private final Bonus bonus;

    public WinningLottoNumbers(Lotto winingLotto, Bonus bonus) {
        validate(winingLotto, bonus);
        this.winingLotto = winingLotto;
        this.bonus = bonus;
    }

    public int countWining(Lotto lotto) {
        return winingLotto.countMatching(lotto);
    }

    public boolean isWiningBonus(Lotto lotto) {
        return lotto.hasNumber(bonus.get());
    }

    private void validate(Lotto lotto, Bonus bonus) {
        if (validateDuplication(lotto, bonus)) {
            throwException(BONUS_DUPLICATION_ERROR_MESSAGE.get());
        }
    }

    private boolean validateDuplication(Lotto lotto, Bonus bonus) {
        return lotto.hasNumber(bonus.get());
    }

    private void throwException(String errorMessage) {
        throw new IllegalArgumentException(errorMessage);
    }
}
