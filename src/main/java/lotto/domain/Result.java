package lotto.domain;

import static lotto.global.ErrorMessage.BONUS_BALL_INCLUDE_ERROR;

public class Result {
    private final Lotto winningLotto;
    private final int bonusBall;

    public Result(Lotto lotto, int bonusBall) {
        validateWinningResult(lotto, bonusBall);
        this.winningLotto = lotto;
        this.bonusBall = bonusBall;
    }

    private void validateWinningResult(Lotto lotto, int bonusBall) {
        if (lotto.containsNumber(bonusBall)) {
            throw new IllegalArgumentException(BONUS_BALL_INCLUDE_ERROR.getMessage());
        }
    }

    public int matchWinningLotto(Lotto lotto) {
        return this.winningLotto.matchNumber(lotto);
    }

    public boolean matchBonusBall(Lotto lotto) {
        return lotto.containsNumber(this.bonusBall);
    }
}
