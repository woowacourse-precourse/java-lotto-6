package lotto.domain;

import static lotto.constant.LottoConstant.MAX_LOTTO_NUMBER;
import static lotto.constant.LottoConstant.MIN_LOTTO_NUMBER;
import static lotto.constant.message.ErrorMessage.BONUS_NUMBER_DUPLICATION_ERROR;
import static lotto.constant.message.ErrorMessage.LOTTO_NUMBER_RANGE_ERROR;

public class WinningLotto extends Lotto {
    private int bonusNumber;

    public WinningLotto(Lotto lotto, int bonusNumber) {
        super(lotto.getNumbers());
        validateBonusNumber(lotto, bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validateBonusNumber(Lotto lotto, int bonusNumber) throws IllegalArgumentException {
        validateNumberBoundary(bonusNumber);
        validateDuplication(lotto, bonusNumber);
    }

    private void validateNumberBoundary(int bonusNumber) throws IllegalArgumentException {
        if (bonusNumber < MIN_LOTTO_NUMBER || bonusNumber > MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException(LOTTO_NUMBER_RANGE_ERROR);
        }
    }

    private void validateDuplication(Lotto lotto, int bonusNumber) throws IllegalArgumentException {
        if (lotto.getNumbers().contains(bonusNumber)) {
            throw new IllegalArgumentException(BONUS_NUMBER_DUPLICATION_ERROR);
        }
    }
}
