package lotto.domain;

import lotto.exception.lotto.BonusDuplicateException;

public record WinningNumber(Lotto lotto, BonusNumber bonusNumber) {
    public WinningNumber {
        validateDuplicate(lotto, bonusNumber);
    }

    private void validateDuplicate(final Lotto lotto, final BonusNumber bonusNumber) {
        if (lotto.contains(bonusNumber)) {
            throw new BonusDuplicateException();
        }
    }
}