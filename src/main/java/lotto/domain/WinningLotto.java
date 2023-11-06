package lotto.domain;

import lotto.enums.LottoNumbers;

import java.util.List;

public class WinningLotto {
    private final Lotto lotto;
    private final int bonusNumber;

    public WinningLotto(Lotto lotto, int bonusNumber) {
        validateBonusNumber(bonusNumber);
        validateDuplicate(bonusNumber, lotto);
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
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

    public List<Integer> getNumbers() {
        return lotto.getNumbers();
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
