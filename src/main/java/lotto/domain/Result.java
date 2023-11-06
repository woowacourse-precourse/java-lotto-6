package lotto.domain;


public class Result {
    private static final String BONUS_BALL_INCLUDE_ERROR = "보너스 볼은 당첨 번호와 중복될 수 없습니다.";
    private final Lotto winningLotto;
    private final int bonusBall;

    public Result(Lotto lotto, int bonusBall) {
        validateWinningResult(lotto, bonusBall);
        this.winningLotto = lotto;
        this.bonusBall = bonusBall;
    }

    private void validateWinningResult(Lotto lotto, int bonusBall) {
        if (lotto.containsNumber(bonusBall)) {
            throw new IllegalArgumentException(BONUS_BALL_INCLUDE_ERROR);
        }
    }

    public int matchWinningLotto(Lotto lotto) {
        return this.winningLotto.matchNumber(lotto);
    }

    public boolean matchBonusBall(Lotto lotto) {
        return lotto.containsNumber(this.bonusBall);
    }
}
