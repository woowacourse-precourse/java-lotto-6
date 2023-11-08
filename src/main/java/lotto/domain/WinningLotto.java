package lotto.domain;

import static lotto.domain.constants.LottoConstants.ERROR_LOTTO_NUMBER_RANGE;
import static lotto.domain.constants.LottoConstants.LOTTO_MAX_NUMBER;
import static lotto.domain.constants.LottoConstants.LOTTO_MIN_NUMBER;

public class WinningLotto {
    public static final int BONUS_MIN_NUMBER = LOTTO_MIN_NUMBER;
    public static final int BONUS_MAX_NUMBER = LOTTO_MAX_NUMBER;
    public static final String ERROR_BONUS_BALL_RANGE = ERROR_LOTTO_NUMBER_RANGE;

    private final Lotto lotto;
    private final int bonusBall;

    public WinningLotto(final Lotto lotto, final int bonusBall) {
        this.lotto = lotto;
        validateBonusBall(bonusBall);
        this.bonusBall = bonusBall;
    }

    private void validateBonusBall(final int bonusBall) {
        validateBonusBallInRange(bonusBall);
        validateBonusBallNotInLotto(bonusBall);
    }

    private void validateBonusBallInRange(final int bonusBall) {
        if (isNumberOutOfRange(bonusBall)) {
            throw new IllegalArgumentException(ERROR_BONUS_BALL_RANGE);
        }
    }

    private boolean isNumberOutOfRange(final int number) {
        return number < BONUS_MIN_NUMBER || number > BONUS_MAX_NUMBER;
    }

    private void validateBonusBallNotInLotto(final int bonusBall) {
        if (lotto.contains(bonusBall)) {
            throw new IllegalArgumentException("보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    }
}
