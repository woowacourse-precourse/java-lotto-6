package lotto.domain;

import lotto.exception.DuplicateNumberException;

public class BonusNumber {
    private final LottoNumber bonusNumber;

    private BonusNumber(int bonusNumber) {
        this.bonusNumber = new LottoNumber(bonusNumber);
    }

    public static BonusNumber createBonusNumber(int bonusNumber) {
        return new BonusNumber(bonusNumber);
    }

    public void exceptionIfDuplicate(WinningNumbers winningNumbers) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new DuplicateNumberException();
        }
    }

    public boolean isMatch(Lotto lotto) {
        return lotto.getLottoNumbers()
                .contains(bonusNumber);
    }
}
