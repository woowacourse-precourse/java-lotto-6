package lotto.domain;

import lotto.enums.LottoNumbers;

public class WinningLotto {
    private final Lotto lotto;
    private final int bonusNumber;

    public WinningLotto(Lotto lotto, int bonusNumber) {
        validateBonusNumber(bonusNumber);
        validateDuplicate(bonusNumber, lotto);
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    public Lotto getLotto() {
        return lotto;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    private void validateBonusNumber(int bonusNumber) {
        if (!LottoNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException();
        }
    }

    private void validateDuplicate(int bonusNumber, Lotto lotto) {
        if (lotto.contains(bonusNumber)) {
            throw new IllegalArgumentException();
        }
    }
}
