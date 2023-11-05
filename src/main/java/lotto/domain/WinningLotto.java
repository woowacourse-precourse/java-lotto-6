package lotto.domain;

import lotto.util.ErrorMessages;

public class WinningLotto {
    private final Lotto winningLotto;
    private final int bonusNumber;

    public WinningLotto(Lotto winningLotto, int bonusNumber) {
        validateBonusNumber(winningLotto, bonusNumber);
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    private void validateBonusNumber(Lotto winningLotto, int bonusNumber) {
        if (containDuplicateNumber(winningLotto, bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessages.DUPLICATE_BONUS_NUMBER_ERROR.getMessage());
        }
    }

    private boolean containDuplicateNumber(Lotto winningLotto, int bonusNumber) {
        return winningLotto.getNumbers()
                .contains(bonusNumber);
    }

    public Lotto getWinningLotto() {
        return winningLotto;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
