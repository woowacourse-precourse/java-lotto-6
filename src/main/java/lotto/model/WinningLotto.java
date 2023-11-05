package lotto.model;

import static lotto.utils.LottoException.DUPLICATED_BONUS_NUMBER;
import static lotto.utils.LottoException.LESS_THAN_MINIMUM_LOTTO_NUMBER;
import static lotto.utils.LottoException.MORE_THAN_MAXIMUM_LOTTO_NUMBER;

import lotto.utils.LottoException;

public class WinningLotto {
    private static final int MINIMUM_LOTTO_NUMBER = 1;
    private static final int MAXIMUM_LOTTO_NUMBER = 45;
    private final Lotto lotto;
    private final int bonusNumber;

    public WinningLotto(final Lotto lotto, final int bonusNumber) {
        validate(bonusNumber);
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    private void validate(int bonusNumber) {
        validateBonusNumberRange(bonusNumber);
        validateIsLottoContain(bonusNumber);
    }

    private void validateBonusNumberRange(int bonusNumber) {
        validateIsLessThanMinimumLottoNumber(bonusNumber);
        validateIsMoreThanMaximumLottoNumber(bonusNumber);
    }

    private void validateIsLessThanMinimumLottoNumber(int bonusNumber) {
        if (bonusNumber < MINIMUM_LOTTO_NUMBER) {
            LESS_THAN_MINIMUM_LOTTO_NUMBER.throwException();
        }
    }

    private void validateIsMoreThanMaximumLottoNumber(int bonusNumber) {
        if (bonusNumber > MAXIMUM_LOTTO_NUMBER) {
            MORE_THAN_MAXIMUM_LOTTO_NUMBER.throwException();
        }
    }

    private void validateIsLottoContain(int bonusNumber) {
        if (lotto.isContain(bonusNumber)) {
            DUPLICATED_BONUS_NUMBER.throwException();
        }
    }
}
