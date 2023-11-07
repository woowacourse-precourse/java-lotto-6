package lotto.domain;

import static lotto.global.ErrorMessage.BONUS_BALL_INCLUDE_ERROR;

public class Customer {
    private final Lotto userLotto;
    private final int bonusBall;

    public Customer(final Lotto lotto, final int bonusBall) {
        validateWinningResult(lotto, bonusBall);
        this.userLotto = lotto;
        this.bonusBall = bonusBall;
    }

    private void validateWinningResult(final Lotto lotto, final int bonusBall) {
        if (lotto.containsNumber(bonusBall)) {
            throw new IllegalArgumentException(BONUS_BALL_INCLUDE_ERROR.getMessage());
        }
    }

    public int matchWinningLotto(final Lotto lotto) {
        return this.userLotto.matchNumber(lotto);
    }

    public boolean matchBonusBall(final Lotto lotto) {
        return lotto.containsNumber(this.bonusBall);
    }
}
