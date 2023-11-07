package lotto.domain;

import lotto.exception.DuplicateBallNumberException;

public class WinningNumbers {
    private final Lotto winningLotto;
    private final LottoBall bonusNumber;

    public WinningNumbers(Lotto winningLotto, LottoBall bonusNumber) {
        validateBonusNotInLotto(winningLotto, bonusNumber);
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    private void validateBonusNotInLotto(Lotto winningLotto, LottoBall bonusNumber) {
        if (winningLotto.contains(bonusNumber)) {
            throw new DuplicateBallNumberException();
        }
    }

}
