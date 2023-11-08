package lotto.domain.roulette;

import lotto.domain.lotto.Lotto;

import static lotto.constant.ExceptionMessage.*;

public class WinningLotto {
    private Lotto lotto;
    private int bonusNumber;

    public WinningLotto(Lotto lotto, int bonusNumber) {
        validateNumberRange(bonusNumber);
        validateContainNumber(lotto, bonusNumber);
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    public static WinningLotto of(Lotto lotto, int bonusNumber) {
        return new WinningLotto(lotto, bonusNumber);
    }

    public Lotto getNumbers() {
        return lotto;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public void validateContainNumber(Lotto lotto, int bonusNumber) {
        if (lotto.isContainNumber(bonusNumber)) {
            throw new IllegalArgumentException(INPUT_BONUS_NUMBER_DUPLICATE_ERROR_MESSAGE.getMessage());
        }
    }

    public void validateNumberRange(int bonusNumber) {
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException(INPUT_BOUNUS_NUMBER_RANGE_ERROR_MESSAGE.getMessage());
        }
    }
}
