package lotto.model;

import static lotto.exception.InvalidLottoException.InvalidLottoError.DUPLICATE_LOTTO;
import static lotto.exception.InvalidLottoException.InvalidLottoError.INVALID_LOTTO_RANGE;
import static lotto.model.Lotto.LOTTO_MAX_NUMBER;
import static lotto.model.Lotto.LOTTO_MIN_NUMBER;

import lotto.exception.InvalidLottoException;

public class User {
    private final Lotto lotto;
    private final int bonusNumber;

    public User(Lotto lotto, int bonusNumber) {
        validateRange(bonusNumber);
        validateDuplicate(lotto, bonusNumber);
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    private void validateRange(int bonusNumber) {
        if (bonusNumber < LOTTO_MIN_NUMBER || LOTTO_MAX_NUMBER < bonusNumber) {
            throw new InvalidLottoException(INVALID_LOTTO_RANGE);
        }
    }

    private void validateDuplicate(Lotto lotto, int bonusNumber) {
        if (lotto.contains(bonusNumber)) {
            throw new InvalidLottoException(DUPLICATE_LOTTO);
        }
    }

    public Lotto getLotto() {
        return lotto;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
