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

    public MatchDetail match(Lotto lotto) {
        return new MatchDetail(
                lotto.getMatchedCount(winningLotto),
                lotto.contains(bonusNumber)
        );
    }

    private void validateBonusNotInLotto(Lotto winningLotto, LottoBall bonusNumber) {
        if (winningLotto.contains(bonusNumber)) {
            throw new DuplicateBallNumberException();
        }
    }

}
